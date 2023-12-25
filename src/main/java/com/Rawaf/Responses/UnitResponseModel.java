package com.Rawaf.Responses;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitResponseModel {

    private int dealDetailsId;
    private int id;
    private int projectId;
    private int projectNumber;
    private String propertyCodeId;
    private String building;
    private String type;
    private String floor;
    private int area;
    private int bedroom;
    private int salah;
    private int majlis;
    private int diningRoom;
    private int bathroom;
    private int kitchen;
    private int storageRoom;
    private int laundryRoom;
    private int clothRoom;
    private int price;
    private String otherFeatures;
    private List<Object> mediaRef;
    private int depositPrice;
    private String projectTitle;
    private int maidRoom;
    private String status;
    private Status statusl;
    private String projectLocation;
    private String city;
    private String tour360;
    private boolean openPayment;
    private String refImage;
    private String parking;
    private Object furnitured;
    private String contractType;
    private List<Object> propertyImages;
    private List<PaymentType> paymentTypes;
    private Object paymentMethod;
    private Object advertiseId;
    private Object verified;
    private Object discount;
    private Object englishOtherFeatures;

    // Constructor and other methods...

    public int getDealDetailsId() {
        return dealDetailsId;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public String getPropertyCodeId() {
        return propertyCodeId;
    }

    public String getBuilding() {
        return building;
    }

    public String getType() {
        return type;
    }

    public String getFloor() {
        return floor;
    }

    public int getArea() {
        return area;
    }

    public int getBedroom() {
        return bedroom;
    }

    public int getSalah() {
        return salah;
    }

    public int getMajlis() {
        return majlis;
    }

    public int getDiningRoom() {
        return diningRoom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public int getStorageRoom() {
        return storageRoom;
    }

    public int getLaundryRoom() {
        return laundryRoom;
    }

    public int getClothRoom() {
        return clothRoom;
    }

    public int getPrice() {
        return price;
    }

    public String getOtherFeatures() {
        return otherFeatures;
    }

    public List<Object> getMediaRef() {
        return mediaRef;
    }

    public int getDepositPrice() {
        return depositPrice;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public int getMaidRoom() {
        return maidRoom;
    }

    public String getStatus() {
        return status;
    }

    public Status getStatusl() {
        return statusl;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public String getCity() {
        return city;
    }

    public String getTour360() {
        return tour360;
    }

    public boolean isOpenPayment() {
        return openPayment;
    }

    public String getRefImage() {
        return refImage;
    }

    public String getParking() {
        return parking;
    }

    public Object getFurnitured() {
        return furnitured;
    }

    public String getContractType() {
        return contractType;
    }

    public List<Object> getPropertyImages() {
        return propertyImages;
    }

    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public Object getPaymentMethod() {
        return paymentMethod;
    }

    public Object getAdvertiseId() {
        return advertiseId;
    }

    public Object getVerified() {
        return verified;
    }

    public Object getDiscount() {
        return discount;
    }

    public Object getEnglishOtherFeatures() {
        return englishOtherFeatures;
    }

    public static class Status {
        private int id;
        private String arabicName;
        private String englishName;
        private String type;
        private String code;
        private Object arabicDescription;
        private Object englishDescription;

        // Getter and Setter methods...

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getArabicName() {
            return arabicName;
        }

        public void setArabicName(String arabicName) {
            this.arabicName = arabicName;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getArabicDescription() {
            return arabicDescription;
        }

        public void setArabicDescription(Object arabicDescription) {
            this.arabicDescription = arabicDescription;
        }

        public Object getEnglishDescription() {
            return englishDescription;
        }

        public void setEnglishDescription(Object englishDescription) {
            this.englishDescription = englishDescription;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentType {
        private int id;
        private String arabicName;
        private String englishName;
        private String type;
        private String code;
        private String arabicDescription;
    }
}
