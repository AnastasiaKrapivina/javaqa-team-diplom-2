package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void testCreditAccountExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -100,
                    5_000,
                    15);
        });
    }

    @Test
    public void testCreditAccountExceptionCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    -5_000,
                    15);
        });
    }

    @Test
    public void testCreditAccountExceptionRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5_000,
                    -15);
        });
    }

    @Test
    public void shouldAddToNullBalancePositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNullBalanceNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceNegativeAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalancePositiveAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void cardPaymentsPositiveBalancePositiveAmount() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void cardPaymentsPositiveBalanceNegativeAmount() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void cardPaymentsPositiveBalanceMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(9_000);

        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void cardPaymentsNullBalancePositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void cardPaymentsNullBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void cardPaymentsNullBalanceMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void calculatingInterestOnANegativeBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.pay(400);
        account.yearChange();

        Assertions.assertEquals(-30, account.getBalance());
    }

    @Test
    public void calculatingInterestOnAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                400,
                5_000,
                15
        );
        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void calculatingInterestOnANullBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.pay(200);
        account.yearChange();

        Assertions.assertEquals(0, account.getBalance());
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
        Assertions.assertEquals(5000, account.getCreditLimit());
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
