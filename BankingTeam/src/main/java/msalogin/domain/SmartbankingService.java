package msalogin.domain;

public interface SmartbankingService {
    void createSmartBanking (int customerId, String bankingId, String password);
    void deleteSmartBanking (int customerId);
    Smartbanking getSmartBanking(int customerId);
    Smartbanking save(String data);
}

