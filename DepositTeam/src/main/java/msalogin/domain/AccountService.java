package msalogin.domain;

public interface AccountService {
    void createAccount (String customerId);
    void deleteAccount (String customerId);
    void depositAccount(String customerId, Double money);
    void withdrawAccount(String customerId, Double money);
    Account getAccount(String customerId);
    Account save(String data);
}
