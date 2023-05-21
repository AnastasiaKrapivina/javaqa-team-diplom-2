package ru.netology.javaqadiplom;

public class Bank {

    /**
     * Операция перевода указанной суммы с одного счёта на другой.
     * Если операция прошла успешно, то баланс счёта from должен
     * уменьшиться на эту сумму, а баланс счёта to увеличиться.
     * Если операция прошла неуспешно, балансы обоих счетов никак
     * измениться не должны.
     *
     * @param from   - счёт с которого переводим
     * @param to     - счёт на который переводим
     * @param amount - сумма перевода
     * @return - true если операция прошла успешно, false иначе
     */
    protected int from;
    protected int to;

    public Bank (int from, int to) {
        this.from = from;
        this.to = to;
    }
    public boolean transfer(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (from <= 0) {
            return false;
        }
        if (from >= amount) {
            to = to + amount;
            from = from - amount;
        } else {
            return false;
        }
        return true;
    }
    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
