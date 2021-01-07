import java.io.IOException;
import java.security.Provider;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class TpLoginModule implements LoginModule {
	public static final String testuser="toumanari";
	public static final String testpassword="ahmed2006";
	private CallbackHandler callbackHandler=null;
	Provider
	private boolean authsucces=false;
	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return authsucces;
	}

	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return authsucces;
	}

	@Override
	public void initialize(Subject arg0, CallbackHandler callbackHandler,
			Map<String, ?> arg2, Map<String, ?> arg3) {
		// TODO Auto-generated method stub
this.callbackHandler=callbackHandler;
	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbackArray=new Callback[2];
		callbackArray[0]=new NameCallback("username");
		callbackArray[1]=new PasswordCallback("password",false);
		try {
			callbackHandler.handle(callbackArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		String name=((NameCallback) callbackArray[0]).getName();
		String password=new String (((PasswordCallback) callbackArray[1]).getPassword());
		if (testuser.equals(name) && testpassword.equals(password)){
			System.out.println("authentification avec succes");
			 authsucces=true;
		}
		else
		{System.out.println("authentification echec");
		 authsucces=false;}
		
		return authsucces;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return authsucces;
	}

}
