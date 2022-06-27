package msalogin.domain;

public interface LoginService {
    void loginValidate (int customerId, String bankingId, String password);
}
