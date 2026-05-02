package utils;

import dto.UserRegistrationDTO;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;

import java.util.Random;

public class DataProviderUtil {
    @DataProvider(name = "validSearchData")
    public Object[] validSearchData() {
        return new Object[]{"Avatar", "Batman", "The Devil Wears Prada 2"};
    }

    @DataProvider(name = "noResultData")
    public Object[] noResultData() {
        return new Object[]{RandomString.make(10)};
    }

    @DataProvider(name = "blankData")
    public Object[] blankData() {
        return new Object[]{""};
    }

    @DataProvider(name = "userRegistrationValidData")
    public Object[] userRegistrationValidData() {
        return new Object[]{new UserRegistrationDTO("denUserQa2026" + RandomString.make(3),
                "12345qwerQWER",
                "12345qwerQWER",
                "denUserQa2026" + RandomString.make(3) + "@gmail.com")};
    }

    @DataProvider(name = "userWithTakenEmail")
    public Object[] userWithTakenEmail() {
        return new Object[]{new UserRegistrationDTO("denUserQa2026" + RandomString.make(3),
                "12345qwerQWER",
                "12345qwerQWER",
                "user@gmail.com")};
    }

    @DataProvider(name = "userWithInvalidConfirmPassword")
    public Object[] userWithInvalidConfirmPassword() {
        return new Object[]{new UserRegistrationDTO("denUserQa2026" + RandomString.make(3),
                "12345qwerQWER",
                "12345qwer",
                "denUserQa2026" + RandomString.make(3) + "@gmail.com")};
    }

    @DataProvider(name = "userWithTakenUsername")
    public Object[] userWithTakenUsername() {
        return new Object[]{new UserRegistrationDTO("user",
                "12345qwerQWER",
                "12345qwer",
                "denUserQa2026" + RandomString.make(3) + "@gmail.com")};
    }
}
