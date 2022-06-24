package msalogin.domain;

public interface AccountService {
    void createAccount (int customerId);
    void deleteAccount (int customerId);
    void depositAccount(int customerId, Double money);
    void withdrawAccount(int customerId, Double money);
    Account getAccount(int customerId);
    Account save(String data);
}
