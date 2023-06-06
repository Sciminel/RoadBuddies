package com.roadbuddies.rbapi.service.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadbuddies.rbapi.model.Account;
import com.roadbuddies.rbapi.model.Role;
import com.roadbuddies.rbapi.repository.AccountRepository;
import com.roadbuddies.rbapi.repository.RoleRepository;
import com.roadbuddies.rbapi.service.AccountService;
import com.roadbuddies.rbapi.util.EntityUpdater;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	private RoleRepository roleRepository;
	
	@Override
	public List<Account> getAllAccounts() {
		return this.accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long id) {
		// L'utilisation d'un getById genere une erreur hibernate... Get recupere en lazy et findBy en eager (A REVOIR) 
		// return accountRepository.getById(id);
		
		// Gérer une exeption pour verifier qu'un account a bien été recup
		return this.accountRepository.findById(id).get();
	}
	
	@Override
	public Account getAccountByUsername(String username, String password) {
		
		// Gerer l'exeption d'un account a chercher a partir d'un username et d'un password faux 
		
		Account account = this.accountRepository.findByUsername(username);
		
		this.authenticate(password, account.getPassword());
		return account;
	}

	@Override
	public Account saveAccount(Account account) {
		
		// Gerer une exeption pour voir si aucune des values n'est null ou autre erreur possible 
		account.setPassword(this.passwordHashed(account.getPassword()));
		
		// Attribuer un role a un account avant le save
		Role accountRole = this.roleRepository.findByName("utilisateur");
		account.getRoles().add(accountRole);
		
		return this.accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account, Long id) {

		// Gerer des exeption pour verifier la modification d'un account
		Account existingAccount = this.accountRepository.findById(id).get();
		
		existingAccount = EntityUpdater.updateEntity(existingAccount, account);
		existingAccount.setPassword(this.passwordHashed(existingAccount.getPassword()));
		
		return this.accountRepository.save(existingAccount);
	}

	@Override
	public void deleteAccountById(Long id) {
		// Verifier qu'un compte peut bien se supprimer 	
		this.accountRepository.deleteById(id);
	}


	/***
	 * Permet de hasher un mot de passe
	 * @param password
	 * @return String
	 */
	private String passwordHashed (String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	/***
	 * Permet de verifier qu'un mot de passe entré par le client est identique a celui trouvé en BDD 
	 * @param password
	 * @param hashedPassword
	 * @return boolean
	 */
	private boolean authenticate(String password, String hashedPassword) {
	    return BCrypt.checkpw(password, hashedPassword);
	}


	
}
