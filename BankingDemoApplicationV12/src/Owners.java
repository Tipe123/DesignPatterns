public enum Owners implements OwnerStrategy{
    DOMESTIC(false,0,"Domestic"),
    FOREIGN(true,500,"Foreign");

    private boolean isforeign;
    private int fee;
    private String name;

    private Owners(boolean isforeign, int fee, String name) {
        this.isforeign = isforeign;
        this.fee = fee;
        this.name = name;
    }

    @Override
    public boolean isForeign() {
        return false;
    }

    @Override
    public int fee() {
        return 0;
    }

    @Override
    public String toString(){
        return name;
    }
}
