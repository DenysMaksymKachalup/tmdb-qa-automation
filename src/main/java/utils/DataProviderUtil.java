package utils;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "validSearchData")
    public Object[] validSearchData() {
        return new Object[] {"Avatar","Batman","The Devil Wears Prada 2"};
    }

    @DataProvider(name = "noResultData")
    public Object[] noResultData() {
        return new Object[] {RandomString.make(10)};
    }

    @DataProvider(name = "blankData")
    public Object[] blankData() {
        return new Object[] {""};
    }
}
