package demo;

public class Command {
    private final String region;
    private final String IP;
    private final String RSA;
    private final Mediator mediator;
    private String data;

    public Command(String region, String ip, String rsa, Mediator mediator) {
        this.region = region;
        this.IP = ip;
        this.RSA = rsa;
        this.mediator = mediator;
        this.data = "A lot of '"+region+"' Data. ";
    }

    public void distributeData() {
        mediator.doNotify(this);
    }

    public void evacuateServer() {
        mediator.doNotify(this);
        mediator.remove(this);
    }

    public String getData() {
        return data;
    }

    public void appendData(String data) {
        this.data += data;
        System.out.println("Data Received At: "+region);
    }

    public String getRegion() {
        return region;
    }

    public String getIP() {
        return IP;
    }

    public String getRSA() {
        return RSA;
    }
}
