
package seminar1.LocationsAPI.TopCities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import seminar1.location.Countrysem;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "LocalizedName",
    "EnglishName",
    "Level",
    "LocalizedType",
    "EnglishType",
    "CountryID"
})
public class AdministrativeArea {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("Level")
    private Integer level;
    @JsonProperty("LocalizedType")
    private String localizedType;
    @JsonProperty("EnglishType")
    private String englishType;
    @JsonProperty("CountryID")
    private String countryID;

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    @JsonProperty("LocalizedName")
    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    @JsonProperty("EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    @JsonProperty("EnglishName")
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @JsonProperty("Level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("LocalizedType")
    public String getLocalizedType() {
        return localizedType;
    }

    @JsonProperty("LocalizedType")
    public void setLocalizedType(String localizedType) {
        this.localizedType = localizedType;
    }

    @JsonProperty("EnglishType")
    public String getEnglishType() {
        return englishType;
    }

    @JsonProperty("EnglishType")
    public void setEnglishType(String englishType) {
        this.englishType = englishType;
    }

    @JsonProperty("CountryID")
    public String getCountryID() {
        return countryID;
    }

    @JsonProperty("CountryID")
    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "Version",
        "Key",
        "Type",
        "Rank",
        "LocalizedName",
        "Country",
        "AdministrativeArea"
    })

    public static class Location {

        @JsonProperty("Version")
        private Integer version;
        @JsonProperty("Key")
        private String key;
        @JsonProperty("Type")
        private String type;
        @JsonProperty("Rank")
        private Integer rank;
        @JsonProperty("LocalizedName")
        private String localizedName;
        @JsonProperty("Country")
        private Countrysem countrysem;
        @JsonProperty("AdministrativeArea")
        private seminar1.location.AdministrativeArea administrativeArea;

        @JsonProperty("Version")
        public Integer getVersion() {
            return version;
        }

        @JsonProperty("Version")
        public void setVersion(Integer version) {
            this.version = version;
        }

        @JsonProperty("Key")
        public String getKey() {
            return key;
        }

        @JsonProperty("Key")
        public void setKey(String key) {
            this.key = key;
        }

        @JsonProperty("Type")
        public String getType() {
            return type;
        }

        @JsonProperty("Type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("Rank")
        public Integer getRank() {
            return rank;
        }

        @JsonProperty("Rank")
        public void setRank(Integer rank) {
            this.rank = rank;
        }

        @JsonProperty("LocalizedName")
        public String getLocalizedName() {
            return localizedName;
        }

        @JsonProperty("LocalizedName")
        public void setLocalizedName(String localizedName) {
            this.localizedName = localizedName;
        }

        @JsonProperty("Country")
        public Countrysem getCountry() {
            return countrysem;
        }

        @JsonProperty("Country")
        public void setCountry(Countrysem countrysem) {
            this.countrysem = countrysem;
        }

        @JsonProperty("AdministrativeArea")
        public seminar1.location.AdministrativeArea getAdministrativeArea() {
            return administrativeArea;
        }

        @JsonProperty("AdministrativeArea")
        public void setAdministrativeArea(seminar1.location.AdministrativeArea administrativeArea) {
            this.administrativeArea = administrativeArea;
        }

    }
}
