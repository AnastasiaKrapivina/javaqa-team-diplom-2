package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankTest {

    @Test // Операция перевода указанной суммы с from на to
    public void transferOfTheSpecifiedPositiveAmount() {
        Bank account = new Bank(4000, 2000);
        account.transfer(500);

        Assertions.assertEquals(3500, account.getFrom());
        Assertions.assertEquals(2500, account.getTo());
    }

    @Test // Операция перевода указанной суммы с from на to
    public void transferOfTheSpecifiedNegativeAmount() {
        Bank account = new Bank(4000, 2000);
        account.transfer(-500);

        Assertions.assertEquals(4000, account.getFrom());
        Assertions.assertEquals(2000, account.getTo());
    }

    @Test
    public void transferFromEqualsAmount() {
        Bank account = new Bank(4000, 2000);
        account.transfer(4000);

        Assertions.assertEquals(0, account.getFrom());
        Assertions.assertEquals(6000, account.getTo());
    }

    @Test // Операция перевода указанной суммы с from на to
    public void transferFromLessToPositiveAmount() {
        Bank account = new Bank(2000, 4000);
        account.transfer(2500);

        Assertions.assertEquals(2000, account.getFrom());
        Assertions.assertEquals(4000, account.getTo());
    }

    @Test // Операция перевода указанной суммы с from на to
    public void transferNegativeFromPositiveAmount() {
        Bank account = new Bank(-4000, 4000);
        account.transfer(2500);

        Assertions.assertEquals(-4000, account.getFrom());
        Assertions.assertEquals(4000, account.getTo());
    }

    @Test
    public void transferToNegative() {
        Bank account = new Bank(4000, -4000);
        account.transfer(4000);

        Assertions.assertEquals(0, account.getFrom());
        Assertions.assertEquals(0, account.getTo());
    }

}