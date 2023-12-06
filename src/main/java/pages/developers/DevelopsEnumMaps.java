package pages.developers;

import java.util.EnumMap;

public class DevelopsEnumMaps {
    protected static final EnumMap<Developers, String> DEVELOPERS_MAP = new EnumMap<>(Developers.class);

    public enum Developers {
        MARQ_COMMUNITIES, UPWYDE_DEVELOPMENTS, AFFIX_DEVELOPMENT, EIGHT_DEVELOPMENTS,
        ERG_DEVELOPMENTS, ICAPITAL_DEVELOPMENTS, LOCATIONS_DEVELOPMENTS, MANARA_DEVELOPMENTS,
        ORBIT_DEVELOPMENTS, PLAZA_GARDENS_DEVELOPMENTS, ROYAL_DEVELOPMENTS, WADI_DEGLA_DEVELOPMENT,
        SERAC_DEVELOPMENT, PRIME_DEVELOPMENTS, LAZAN_URBAN_DEVELOPMENTS, ELMASRIA_GROUP_DEVELOPMENTS,
        AREVA_DEVELOPMENT, VALDA_DEVELOPMENTS, ELGABRY_DEVELOPMENT, SKY_WAY_DEVELOPMENTS,
        KVRD_DEVELOPMENT, RFCO_DEVELOPMENT, EG_MASTER_DEVELOPMENT, ALKARMA_DEVELOPMENTS,
        CAIRO_CAPITAL_DEVELOPMENTS, CATALYST_DEVELOPMENTS, ELDAU_DEVELOPMENT, ELFATH_DEVELOPMENT

        }

    static {
            DEVELOPERS_MAP.put(Developers.MARQ_COMMUNITIES,"the-marq-communities");
            DEVELOPERS_MAP.put(Developers.UPWYDE_DEVELOPMENTS,"upwyde-developments");
            DEVELOPERS_MAP.put(Developers.AFFIX_DEVELOPMENT,"affix-development");
            DEVELOPERS_MAP.put(Developers.EIGHT_DEVELOPMENTS,"eight-developments");
            DEVELOPERS_MAP.put(Developers.ERG_DEVELOPMENTS,"erge-developments");
            DEVELOPERS_MAP.put(Developers.ICAPITAL_DEVELOPMENTS,"i-capital-developments");
            DEVELOPERS_MAP.put(Developers.LOCATIONS_DEVELOPMENTS,"locations-developments");
            DEVELOPERS_MAP.put(Developers.MANARA_DEVELOPMENTS,"manara-developments");
            DEVELOPERS_MAP.put(Developers.ORBIT_DEVELOPMENTS,"orbit-developments");
            DEVELOPERS_MAP.put(Developers.PLAZA_GARDENS_DEVELOPMENTS,"plaza-gardens-developments");
            DEVELOPERS_MAP.put(Developers.ROYAL_DEVELOPMENTS,"royal-developments");
            DEVELOPERS_MAP.put(Developers.WADI_DEGLA_DEVELOPMENT,"wadi-degla-development");
            DEVELOPERS_MAP.put(Developers.SERAC_DEVELOPMENT,"serac-development");
            DEVELOPERS_MAP.put(Developers.PRIME_DEVELOPMENTS,"prime-developments");
            DEVELOPERS_MAP.put(Developers.LAZAN_URBAN_DEVELOPMENTS,"lazan-urban-developments-lud");
            DEVELOPERS_MAP.put(Developers.ELMASRIA_GROUP_DEVELOPMENTS,"el-masria-group-developments");
            DEVELOPERS_MAP.put(Developers.AREVA_DEVELOPMENT,"areva-development");
            DEVELOPERS_MAP.put(Developers.VALDA_DEVELOPMENTS,"valda-developments");
            DEVELOPERS_MAP.put(Developers.ELGABRY_DEVELOPMENT,"el-gabry-development");
            DEVELOPERS_MAP.put(Developers.SKY_WAY_DEVELOPMENTS,"sky-way-developments");
            DEVELOPERS_MAP.put(Developers.KVRD_DEVELOPMENT,"kvrd-development");
            DEVELOPERS_MAP.put(Developers.RFCO_DEVELOPMENT,"rfco-development");
            DEVELOPERS_MAP.put(Developers.EG_MASTER_DEVELOPMENT,"eg-master-development");
            DEVELOPERS_MAP.put(Developers.ALKARMA_DEVELOPMENTS,"alkarma-developments");
            DEVELOPERS_MAP.put(Developers.CAIRO_CAPITAL_DEVELOPMENTS,"cairo-capital-developments");
            DEVELOPERS_MAP.put(Developers.CATALYST_DEVELOPMENTS,"catalyst-developments");
            DEVELOPERS_MAP.put(Developers.ELDAU_DEVELOPMENT,"eldau-development");
            DEVELOPERS_MAP.put(Developers.ELFATH_DEVELOPMENT,"el-fath-development");

    }
}
