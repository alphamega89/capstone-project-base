package msalogin.domain;

public interface LoginService {
    Boolean loginValidate (String bankingId, String password);
    String loginValidateT (String bankingId, String password);
}
