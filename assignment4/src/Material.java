interface Material {
    String getMaterial();
}

class Leather implements Material {
    @Override
    public String getMaterial() {
        return "Leather";
    }
}

class Synthetic implements Material {
    @Override
    public String getMaterial() {
        return "Synthetic";
    }
}