package testcom.imdb.testuser;

import com.imdb.user.Registration;

public class TestRegistration extends Registration {



    public static void main(String[] args) {

        Registration registration = new TestRegistration();

        registration.createUser("Anatoly Bardyuk", "Ana-Ana");
        registration.createUser("Franklin Gonzalez", "12345");
        registration.createUser("Paruyr Hayrikyan", "hayastan1900");
        registration.createUser(" Naira Zohrabyan", "narasus");
        registration.createUser("Franklin Gonzalez", "687523a");

    }
}
