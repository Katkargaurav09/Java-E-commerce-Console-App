    public class Product {
        private int id;
        private String name;
        private String brand;
        private double price;

        // Constructor
        public Product() {
        }

        public Product(int id, String name, String brand, double price) throws Exception {
            setId(id);
            setName(name);
            setBrand(brand);
            setPrice(price);
        }

        // Getter & Setter
        public int getId() {
            return this.id;
        }

        public void setId(int id) throws ProductIdException {
            if (id <= 0) {
                throw new ProductIdException();
            }
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) throws ProductNameException {
            if (name == null || name.trim().isEmpty()) {
                throw new ProductNameException();
            }
            this.name = name;
        }

        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) throws ProductPriceException {
            if (price <= 0) {
                throw new ProductPriceException();
            }
            this.price = price;
        }

        // Display cart
        public void displayCart() {
            System.out.println("Displaying Cart : " + toString());
        }

        public static Product createProduct(int id, String name, String brand, double price) throws Exception {
            return new Product(id, name, brand, price);
        }

        // Override methods
        @Override
        public String toString() {
            return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((brand == null) ? 0 : brand.hashCode());
            long temp;
            temp = Double.doubleToLongBits(price);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Product other = (Product) obj;
            if (id != other.id)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (brand == null) {
                if (other.brand != null)
                    return false;
            } else if (!brand.equals(other.brand))
                return false;
            if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
                return false;
            return true;
        }

    }