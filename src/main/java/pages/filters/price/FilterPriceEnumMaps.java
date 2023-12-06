package pages.filters.price;

import java.util.EnumMap;

public class FilterPriceEnumMaps {

    protected static final EnumMap<PriceValue, Integer> PRICES_FROM_MAP = new EnumMap<>(PriceValue.class);
    protected static final EnumMap<PriceValue, Integer> PRICES_TO_MAP = new EnumMap<>(PriceValue.class);

    protected static final EnumMap<DownPaymentValue, Integer> DOWN_PAYMENT_FROM_MAP = new EnumMap<>(DownPaymentValue.class);
    protected static final EnumMap<DownPaymentValue, Integer> DOWN_PAYMENT_TO_MAP = new EnumMap<>(DownPaymentValue.class);

    protected static final EnumMap<InstallmentValue, Integer> INSTALLMENT_FROM_MAP = new EnumMap<>(InstallmentValue.class);
    protected static final EnumMap<InstallmentValue, Integer> INSTALLMENT_TO_MAP = new EnumMap<>(InstallmentValue.class);

    public enum PriceValue {
        _1_MILLION, _5_MILLION, _10_MILLION, _15_MILLION, _20_MILLION, _25_MILLION,
        _30_MILLION, _35_MILLION, _40_MILLION, _45_MILLION, _50_MILLION;

        public static void initializeMaps(PriceValue priceFromValue) {
            for (int i = 0; i < values().length; i++) {
                PRICES_FROM_MAP.put(values()[i], i + 1);

                if (priceFromValue != null && values()[i] == priceFromValue) {
                    int toIndex = 1;
                    for (int j = i + 1; j < values().length; j++) {
                        PRICES_TO_MAP.put(values()[j], toIndex++);
                    }
                }
            }
        }
    }

    public enum DownPaymentValue {
        _100K, _200K, _300K, _400K, _500K, _600K, _700K, _800K, _900K, _1M,
        _1_1M, _1_2M, _1_3M, _1_4M, _1_5M, _1_6M, _1_7M, _1_8M, _1_9M, _2M,
        _4M, _6M, _8M, _10M, _20M, _40M, _60M, _80M, _100M;

        public static void initializeMaps(DownPaymentValue downPaymentFromValue) {
            for (int i = 0; i < values().length; i++) {
                DOWN_PAYMENT_FROM_MAP.put(values()[i], i + 1);

                if (downPaymentFromValue != null && values()[i] == downPaymentFromValue) {
                    int toIndex = 1;
                    for (int j = i + 1; j < values().length; j++) {
                        DOWN_PAYMENT_TO_MAP.put(values()[j], toIndex++);
                    }
                }
            }
        }
    }

    public enum InstallmentValue {
        _5K, _10K, _15K, _20K, _25K, _30K, _35K, _40K, _45K, _50K,
        _55K, _60K, _65K, _70K, _75K, _80K, _85K, _90K, _95K, _100K,
        _105K, _110K, _115K, _120K, _125K, _130K, _135K, _140K, _145K, _150K,
        _155K, _160K, _165K, _170K, _175K, _180K, _185K, _190K, _195K, _200K,
        _205K, _210K, _215K, _220K, _225K, _230K, _235K, _240K, _245K, _250K,
        _255K, _260K, _265K, _270K, _275K, _280K, _285K, _290K, _295K, _300K,
        _305K, _310K, _315K, _320K, _325K, _330K, _335K, _340K, _345K, _350K,
        _355K, _360K, _365K, _370K, _375K, _380K, _385K, _390K, _395K, _400K,
        _405K, _410K, _415K, _420K, _425K, _430K, _435K, _440K, _445K, _450K,
        _455K, _460K, _465K, _470K, _475K, _480K, _485K, _490K, _495K, _500K;

        public static void initializeMaps(InstallmentValue installmentFromValue) {
            for (int i = 0; i < values().length; i++) {
                INSTALLMENT_FROM_MAP.put(values()[i], i + 1);

                if (installmentFromValue != null && values()[i] == installmentFromValue) {
                    int toIndex = 1;
                    for (int j = i + 1; j < values().length; j++) {
                        INSTALLMENT_TO_MAP.put(values()[j], toIndex++);
                    }
                }
            }
        }
    }
}
