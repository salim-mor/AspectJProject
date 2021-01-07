import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
public class TpCallbackHandler implements CallbackHandler {
	@Override
	public void handle(Callback[] callbackArray) throws IOException,
			UnsupportedCallbackException {
		NameCallback nameCallback=null;
		PasswordCallback passwordCallback=null;
		int cpt=0;
		while(cpt<callbackArray.length){
			if (callbackArray[cpt] instanceof NameCallback){
				nameCallback=(NameCallback) callbackArray[cpt++];
				System.out.println(nameCallback.getPrompt());
				nameCallback.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
				
			}
			else if (callbackArray[cpt] instanceof PasswordCallback){
				passwordCallback=(PasswordCallback) callbackArray[cpt++];
				System.out.println(passwordCallback.getPrompt());
				passwordCallback.setPassword((new BufferedReader(new InputStreamReader(System.in))).readLine().toCharArray());
				
			}}}}



