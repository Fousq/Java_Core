package kz.zhanbolat.chief.service.finder;

public class SearchParams {
    private Integer minWeight;
    private Integer maxWeight;
    private Boolean isSliced;
    private Boolean isBoiled;
    private Boolean isFried;

    public SearchParams(Builder builder) {
        this.minWeight = builder.minWeight;
        this.maxWeight = builder.maxWeight;
        this.isBoiled = builder.isBoiled;
        this.isFried = builder.isFried;
        this.isSliced = builder.isSliced;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Boolean isSliced() {
        return isSliced;
    }

    public void setSliced(Boolean sliced) {
        isSliced = sliced;
    }

    public Boolean isBoiled() {
        return isBoiled;
    }

    public void setBoiled(Boolean boiled) {
        isBoiled = boiled;
    }

    public Boolean isFried() {
        return isFried;
    }

    public void setFried(Boolean isFried) {
        this.isFried = isFried;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer minWeight;
        private Integer maxWeight;
        private Boolean isSliced;
        private Boolean isBoiled;
        private Boolean isFried;

        public Builder setMinWeight(Integer minWeight) {
            this.minWeight = minWeight;

            return this;
        }

        public Builder setMaxWeight(Integer maxWeight) {
            this.maxWeight = maxWeight;

            return this;
        }

        public Builder setSliced(Boolean isSliced) {
            this.isSliced = isSliced;

            return this;
        }

        public Builder setBoiled(Boolean isBoiled) {
            this.isBoiled = isBoiled;

            return this;
        }

        public Builder setFried(Boolean isFried) {
            this.isFried = isFried;

            return this;
        }

        public SearchParams build() {
            return new SearchParams(this);
        }
    }
}
