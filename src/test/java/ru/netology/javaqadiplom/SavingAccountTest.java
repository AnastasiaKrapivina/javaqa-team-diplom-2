package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldNotCreateAccountWithNegativeBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -100,
                    0,
                    100,
                    5);
        });
    }

    @Test
    public void shouldNotCreateAccountWithNegativeMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    100,
                    -1,
                    100,
                    5
            );
        });
    }

    @Test
    public void shouldNotCreateAccountWithNegativeMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    100,
                    0,
                    -100,
                    5
            );
        });
    }

    @Test
    public void shouldNotCreateAccountWithNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1,
                    0,
                    100_000,
                    -1
            );
        });
    }


    @Test
    public void shouldNotCreateAccountWithMaxBalanceLessThanMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    100,
                    1_000,
                    100,
                    5
            );
        });
    }


    @Test // оплата при балансе больше минимума
    public void shouldPayWithBalanceMoreThanMin() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(4_000);

        Assertions.assertEquals(5_000 - 4_000, account.getBalance());
    }

    @Test // оплата (баланс больше минмума) - пограничные значения
    public void shouldPayWithBalanceMoreThanMin1_001() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_999);

        Assertions.assertEquals(5_000 - 3_999, account.getBalance());
    }

    @Test
    public void shouldNotPayWithBalanceLessMin() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        account.pay(4_001);

        Assertions.assertEquals(5_000, account.getBalance());
    }
    @Test
    public void shouldNotPayWithBalanceLessMinNegativeAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        account.pay(-2_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test  // пополнение счёта (не превысив максимальный баланс)
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test  // пополнение счёта - пограничные значения
    public void shouldAddLessThanMaxBalance9_999() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_999);

        Assertions.assertEquals(2_000 + 7_999, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldNotAddMoreThanMaxBalanceNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                1_000,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(200 / 100 * 15, account.getBalance());
    }
    @Test
    public void testSavingAccountAccountData() {
        SavingAccount account = new SavingAccount(
                200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(1_000, account.getMinBalance());
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }
}
