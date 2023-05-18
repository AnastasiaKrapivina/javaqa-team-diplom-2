package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void testCreditAccountException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5_000,
                    -15);
        });
    }

    @Test
    public void shouldAddToNullBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNullBalanceTwo() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void cardPaymentsPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void cardPaymentsPositiveBalanceTwo() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void cardPaymentsNullBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void cardPaymentsNegativeBalanceLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-4000, account.getBalance());
    }

    @Test
    public void cardPaymentsNegativeBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                -2_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-2000, account.getBalance());
    }

    @Test
    public void cardPaymentsNegativeBalanceMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void calculatingInterestOnANegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(-30, account.getCreditLimit());
    }

    @Test
    public void calculatingInterestOnAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void calculatingInterestOnANullBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void testCreditAccountData() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.setRate(10);

        Assertions.assertEquals(10, account.getRate());
    }

    @Test
    public void testCreditAccountDataPay() {
        Account account = new Account();

        Assertions.assertEquals(false, account.pay(10));
    }

    @Test
    public void testCreditAccountDataAdd() {
        Account account = new Account();

        Assertions.assertEquals(false, account.add(10));
    }

    @Test
    public void testCreditAccountDataYearChange() {
        Account account = new Account();

        Assertions.assertEquals(0, account.yearChange());
    }
}
