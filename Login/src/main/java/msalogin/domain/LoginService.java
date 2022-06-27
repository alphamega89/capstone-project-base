package msalogin.domain;

public interface LoginService {
    Boolean loginValidate (String bankingId, String password);
}
