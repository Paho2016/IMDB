package testcom.imdb.testadmin;

import com.imdb.admin.AdminSignIn;

public class TestAdminSignIn extends AdminSignIn{

    public void RequestSignIn(){
    }

    public static void main(String[] args) {
        AdminSignIn signIn = new AdminSignIn();

        signIn.signIn("fakeUsername", "fakePassword");
        signIn.signIn("Tigran_Jomardyan", "admin.Tigran.111");
    }

}
