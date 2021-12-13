package Enums;

/**
 * @author gauravdhingra
 */
public enum QueryType {
    CHECK_WALLET_BALANCE("check-wallet-balance"),
    CHANGE_LANGUAGE("change-language"),
    OTHERS("others");

    String type;

    QueryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
