package vn.molu.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.molu.dao.impl.UserRepository;
public class UserService implements UserDetailsService {

	UserRepository repository = new UserRepository();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("a");
		vn.molu.domain.User obj = repository.logOn(username);
		System.out.println(obj.getPassword());
		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority(obj.getRole()));

		return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);

	}

}
