package msalogin.domain;

public interface CustomerService {
    void createCustomer (int customerId, String address, String telNo, String name, String juminNo);
    void deleteCustomer (int customerId);
    Customer getCustomer(int customerId);
    Customer save(String data);

}
