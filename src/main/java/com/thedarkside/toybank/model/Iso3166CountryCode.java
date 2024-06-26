package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ISO 3166 Codes for the representation of names of countries and their subdivisions
 */
public enum Iso3166CountryCode {
    AD("AD"),
    AE("AE"),
    AF("AF"),
    AG("AG"),
    AI("AI"),
    AL("AL"),
    AM("AM"),
    AO("AO"),
    AQ("AQ"),
    AR("AR"),
    AS("AS"),
    AT("AT"),
    AU("AU"),
    AW("AW"),
    AX("AX"),
    AZ("AZ"),
    BA("BA"),
    BB("BB"),
    BD("BD"),
    BE("BE"),
    BF("BF"),
    BG("BG"),
    BH("BH"),
    BI("BI"),
    BJ("BJ"),
    BM("BM"),
    BN("BN"),
    BO("BO"),
    BR("BR"),
    BS("BS"),
    BT("BT"),
    BV("BV"),
    BW("BW"),
    BY("BY"),
    BZ("BZ"),
    CA("CA"),
    CC("CC"),
    CD("CD"),
    CF("CF"),
    CG("CG"),
    CH("CH"),
    CI("CI"),
    CK("CK"),
    CL("CL"),
    CM("CM"),
    CN("CN"),
    CO("CO"),
    CR("CR"),
    CU("CU"),
    CV("CV"),
    CX("CX"),
    CY("CY"),
    CZ("CZ"),
    DE("DE"),
    DJ("DJ"),
    DK("DK"),
    DM("DM"),
    DO("DO"),
    DZ("DZ"),
    EC("EC"),
    EE("EE"),
    EG("EG"),
    EH("EH"),
    ER("ER"),
    ES("ES"),
    ET("ET"),
    FI("FI"),
    FJ("FJ"),
    FK("FK"),
    FM("FM"),
    FO("FO"),
    FR("FR"),
    GA("GA"),
    GB("GB"),
    GD("GD"),
    GE("GE"),
    GF("GF"),
    GG("GG"),
    GH("GH"),
    GI("GI"),
    GL("GL"),
    GM("GM"),
    GN("GN"),
    GP("GP"),
    GQ("GQ"),
    GR("GR"),
    GS("GS"),
    GT("GT"),
    GU("GU"),
    GW("GW"),
    GY("GY"),
    HK("HK"),
    HM("HM"),
    HN("HN"),
    HR("HR"),
    HT("HT"),
    HU("HU"),
    ID("ID"),
    IE("IE"),
    IL("IL"),
    IM("IM"),
    IN("IN"),
    IO("IO"),
    IQ("IQ"),
    IR("IR"),
    IS("IS"),
    IT("IT"),
    JE("JE"),
    JM("JM"),
    JO("JO"),
    JP("JP"),
    KE("KE"),
    KG("KG"),
    KH("KH"),
    KI("KI"),
    KM("KM"),
    KN("KN"),
    KP("KP"),
    KR("KR"),
    KW("KW"),
    KY("KY"),
    KZ("KZ"),
    LA("LA"),
    LB("LB"),
    LC("LC"),
    LI("LI"),
    LK("LK"),
    LR("LR"),
    LS("LS"),
    LT("LT"),
    LU("LU"),
    LV("LV"),
    LY("LY"),
    MA("MA"),
    MC("MC"),
    MD("MD"),
    ME("ME"),
    MF("MF"),
    MG("MG"),
    MH("MH"),
    MK("MK"),
    ML("ML"),
    MM("MM"),
    MN("MN"),
    MO("MO"),
    MP("MP"),
    MQ("MQ"),
    MR("MR"),
    MS("MS"),
    MT("MT"),
    MU("MU"),
    MV("MV"),
    MW("MW"),
    MX("MX"),
    MY("MY"),
    MZ("MZ"),
    NA("NA"),
    NC("NC"),
    NE("NE"),
    NF("NF"),
    NG("NG"),
    NI("NI"),
    NL("NL"),
    NO("NO"),
    NP("NP"),
    NR("NR"),
    NU("NU"),
    NZ("NZ"),
    OM("OM"),
    PA("PA"),
    PE("PE"),
    PF("PF"),
    PG("PG"),
    PH("PH"),
    PK("PK"),
    PL("PL"),
    PM("PM"),
    PN("PN"),
    PR("PR"),
    PS("PS"),
    PT("PT"),
    PW("PW"),
    PY("PY"),
    QA("QA"),
    RE("RE"),
    RO("RO"),
    RU("RU"),
    RW("RW"),
    SA("SA"),
    SB("SB"),
    SC("SC"),
    SD("SD"),
    SE("SE"),
    SG("SG"),
    SH("SH"),
    SI("SI"),
    SJ("SJ"),
    SK("SK"),
    SL("SL"),
    SM("SM"),
    SN("SN"),
    SO("SO"),
    SR("SR"),
    SS("SS"),
    ST("ST"),
    SV("SV"),
    SY("SY"),
    SZ("SZ"),
    TC("TC"),
    TD("TD"),
    TF("TF"),
    TG("TG"),
    TH("TH"),
    TJ("TJ"),
    TK("TK"),
    TL("TL"),
    TM("TM"),
    TN("TN"),
    TO("TO"),
    TR("TR"),
    TT("TT"),
    TV("TV"),
    TW("TW"),
    TZ("TZ"),
    UA("UA"),
    UG("UG"),
    UM("UM"),
    US("US"),
    UY("UY"),
    UZ("UZ"),
    VA("VA"),
    VC("VC"),
    VE("VE"),
    VG("VG"),
    VI("VI"),
    VN("VN"),
    VU("VU"),
    WF("WF"),
    WS("WS"),
    YE("YE"),
    YT("YT"),
    ZA("ZA"),
    ZM("ZM"),
    ZW("ZW"),
    AFGHANISTAN("Afghanistan"),
    AKROTIRI("Akrotiri"),
    ALAND_ISLANDS("Aland Islands"),
    ALBANIA("Albania"),
    ALDERNEY("Alderney"),
    ALGERIA("Algeria"),
    AMERICAN_SAMOA("American Samoa"),
    ANDORRA("Andorra"),
    ANGOLA("Angola"),
    ANGUILLA("Anguilla"),
    ANTARCTICA("Antarctica"),
    ANTIGUA_AND_BARBUDA("Antigua and Barbuda"),
    ARGENTINA("Argentina"),
    ARMENIA("Armenia"),
    ARUBA("Aruba"),
    ASCENSION_ISLAND("Ascension Island"),
    ASHMORE_AND_CARTIER_ISLANDS("Ashmore and Cartier Islands"),
    AUSTRALIA("Australia"),
    AUSTRIA("Austria"),
    AZERBAIJAN("Azerbaijan"),
    THE_BAHAMAS("Bahamas, The"),
    BAHRAIN("Bahrain"),
    BAKER_ISLAND("Baker Island"),
    BANGLADESH("Bangladesh"),
    BARBADOS("Barbados"),
    BELARUS("Belarus"),
    BELGIUM("Belgium"),
    BELIZE("Belize"),
    BENIN("Benin"),
    BERMUDA("Bermuda"),
    BHUTAN("Bhutan"),
    BOLIVIA("Bolivia"),
    BONAIRE("Bonaire"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina"),
    BOTSWANA("Botswana"),
    BOUVET_ISLAND("Bouvet Island"),
    BRAZIL("Brazil"),
    BRITISH_INDIAN_OCEAN_TERRITORY("British Indian Ocean Territory"),
    BRUNEI("Brunei"),
    BULGARIA("Bulgaria"),
    BURKINA_FASO("Burkina Faso"),
    BURMA("Burma (Myanmar)"),
    BURUNDI("Burundi"),
    CABO_VERDE("Cabo Verde"),
    CAMBODIA("Cambodia"),
    CAMEROON("Cameroon"),
    CANADA("Canada"),
    CAYMAN_ISLANDS("Cayman Islands"),
    CENTRAL_AFRICAN_REPUBLIC("Central African Republic"),
    CHAD("Chad"),
    CHILE("Chile"),
    CHINA("China"),
    CHRISTMAS_ISLAND("Christmas Island"),
    CLIPPERTON_ISLAND("Clipperton Island"),
    COCOS_KEELING_ISLANDS("Cocos (Keeling) Islands"),
    COLOMBIA("Colombia"),
    COMOROS("Comoros"),
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO("Congo, Democratic Republic of the"),
    REPUBLIC_OF_THE_CONGO("Congo, Republic of the"),
    COOK_ISLANDS("Cook Islands"),
    CORAL_SEA_ISLANDS("Coral Sea Islands"),
    COSTA_RICA("Costa Rica"),
    COTE_D_IVOIRE("Côte d'Ivoire"),
    CRIMEA("Crimea"),
    CROATIA("Croatia"),
    CUBA("Cuba"),
    CURACAO("Curacao"),
    CYPRUS("Cyprus"),
    CYPRUS_TURKISH_CYPRIOT_ADMINISTERED("Cyprus, Turkish Cypriot Administered"),
    CZECHIA("Czechia"),
    DENMARK("Denmark"),
    DHEKELIA("Dhekelia"),
    DJIBOUTI("Djibouti"),
    DOMINICA("Dominica"),
    DOMINICAN_REPUBLIC("Dominican Republic"),
    ECUADOR("Ecuador"),
    EGYPT("Egypt"),
    EL_SALVADOR("El Salvador"),
    EQUATORIAL_GUINEA("Equatorial Guinea"),
    ERITREA("Eritrea"),
    ESTONIA("Estonia"),
    ESWATINI("Eswatini"),
    ETHIOPIA("Ethiopia"),
    FALKLAND_ISLANDS_ISLAS_MALVINAS("Falkland Islands (Islas Malvinas)"),
    FAROE_ISLANDS("Faroe Islands"),
    FIJI("Fiji"),
    FINLAND("Finland"),
    FRANCE("France"),
    FRENCH_GUIANA("French Guiana"),
    FRENCH_POLYNESIA("French Polynesia"),
    FRENCH_SOUTHERN_AND_ANTARCTIC_LANDS("French Southern and Antarctic Lands"),
    GABON("Gabon"),
    GAMBIA_THE("Gambia, The"),
    GEORGIA("Georgia"),
    GERMANY("Germany"),
    GHANA("Ghana"),
    GIBRALTAR("Gibraltar"),
    GREECE("Greece"),
    GREENLAND("Greenland"),
    GRENADA("Grenada"),
    GUADELOUPE("Guadeloupe"),
    GUAM("Guam"),
    GUATEMALA("Guatemala"),
    GUERNSEY("Guernsey"),
    GUINEA("Guinea"),
    GUINEA_BISSAU("Guinea-Bissau"),
    GUYANA("Guyana"),
    HAITI("Haiti"),
    HEARD_AND_MCDONALD_ISLANDS("Heard and McDonald Islands"),
    HERM("Herm"),
    HOLY_SEE_VATICAN_CITY("Holy See (Vatican City)"),
    HONDURAS("Honduras"),
    HONG_KONG("Hong Kong"),
    HOWLAND_ISLAND("Howland Island"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    ILE_AMSTERDAM("Ile Amsterdam"),
    ILE_SAINT_PAUL("Ile Saint-Paul"),
    ILES_CROZET("Iles Crozet"),
    ILES_DES_SAINTES("Iles des Saintes"),
    ILES_EPARSES("Iles Eparses"),
    ILES_KERGUELEN("Iles Kerguelen"),
    INDIA("India"),
    INDONESIA("Indonesia"),
    IRAN("Iran"),
    IRAQ("Iraq"),
    IRELAND("Ireland"),
    ISLE_OF_MAN("Isle of Man"),
    ISRAEL("Israel"),
    ITALY("Italy"),
    JAMAICA("Jamaica"),
    JAN_MAYEN("Jan Mayen"),
    JAPAN("Japan"),
    JARVIS_ISLAND("Jarvis Island"),
    JERSEY("Jersey"),
    JOHNSTON_ATOLL("Johnston Atoll"),
    JORDAN("Jordan"),
    KAZAKHSTAN("Kazakhstan"),
    KENYA("Kenya"),
    KINGMAN_REEF("Kingman Reef"),
    KIRIBATI("Kiribati"),
    KOREA_NORTH("Korea, North"),
    KOREA_SOUTH("Korea, South"),
    KOSOVO("Kosovo"),
    KUWAIT("Kuwait"),
    KYRGYZSTAN("Kyrgyzstan"),
    LA_DESIRADE("La Desirade"),
    LAOS("Laos"),
    LATVIA("Latvia"),
    LEBANON("Lebanon"),
    LESOTHO("Lesotho"),
    LIBERIA("Liberia"),
    LIBYA("Libya"),
    LIECHTENSTEIN("Liechtenstein"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MACAU("Macau"),
    MADAGASCAR("Madagascar"),
    MALAWI("Malawi"),
    MALAYSIA("Malaysia"),
    MALDIVES("Maldives"),
    MALI("Mali"),
    MALTA("Malta"),
    MARIE_GALANTE("Marie-Galante"),
    MARSHALL_ISLANDS("Marshall Islands"),
    MARTINIQUE("Martinique"),
    MAURITANIA("Mauritania"),
    MAURITIUS("Mauritius"),
    MAYOTTE("Mayotte"),
    MEXICO("Mexico"),
    MICRONESIA("Micronesia"),
    MIDWAY_ISLANDS("Midway Islands"),
    MOLDOVA("Moldova"),
    MONACO("Monaco"),
    MONGOLIA("Mongolia"),
    MONTENEGRO("Montenegro"),
    MONTSERRAT("Montserrat"),
    MOROCCO("Morocco"),
    MOZAMBIQUE("Mozambique"),
    NAMIBIA("Namibia"),
    NAURU("Nauru"),
    NAVASSA_ISLAND("Navassa Island"),
    NEPAL("Nepal"),
    NETHERLANDS("Netherlands"),
    NEW_CALEDONIA("New Caledonia"),
    NEW_ZEALAND("New Zealand"),
    NICARAGUA("Nicaragua"),
    NIGER("Niger"),
    NIGERIA("Nigeria"),
    NIUE("Niue"),
    NORFOLK_ISLAND("Norfolk Island"),
    NORTH_MACEDONIA("North Macedonia"),
    NORTHERN_MARIANA_ISLANDS("Northern Mariana Islands"),
    NORWAY("Norway"),
    OMAN("Oman"),
    PAKISTAN("Pakistan"),
    PALAU("Palau"),
    PALESTINIAN_TERRITORIES("Palestinian Territories"),
    PALMYRA_ATOLL("Palmyra Atoll"),
    PANAMA("Panama"),
    PAPUA_NEW_GUINEA("Papua New Guinea"),
    PARACEL_ISLANDS("Paracel Islands"),
    PARAGUAY("Paraguay"),
    PERU("Peru"),
    PHILIPPINES("Philippines"),
    PITCAIRN_ISLANDS("Pitcairn Islands"),
    POLAND("Poland"),
    PORTUGAL("Portugal"),
    PUERTO_RICO("Puerto Rico"),
    QATAR("Qatar"),
    REUNION("Reunion"),
    ROMANIA("Romania"),
    RUSSIA("Russia"),
    RWANDA("Rwanda"),
    SABA("Saba"),
    SAINT_BARTHELEMY("Saint Barthelemy"),
    SAINT_HELENA("Saint Helena"),
    SAINT_KITTS_AND_NEVIS("Saint Kitts and Nevis"),
    SAINT_LUCIA("Saint Lucia"),
    SAINT_MARTIN("Saint Martin"),
    SAINT_PIERRE_AND_MIQUELON("Saint Pierre and Miquelon"),
    SAINT_VINCENT_AND_THE_GRENADINES("Saint Vincent and the Grenadines"),
    SAMOA("Samoa"),
    SAN_MARINO("San Marino"),
    SAO_TOME_AND_PRINCIPE("Sao Tome and Principe"),
    SARK("Sark"),
    SAUDI_ARABIA("Saudi Arabia"),
    SENEGAL("Senegal"),
    SERBIA("Serbia"),
    SEYCHELLES("Seychelles"),
    SIERRA_LEONE("Sierra Leone"),
    SINGAPORE("Singapore"),
    SINT_EUSTATIUS("Sint Eustatius"),
    SINT_MAARTEN("Sint Maarten"),
    SLOVAKIA("Slovakia"),
    SLOVENIA("Slovenia"),
    SOLOMON_ISLANDS("Solomon Islands"),
    SOMALIA("Somalia"),
    SOUTH_AFRICA("South Africa"),
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("South Georgia and the South Sandwich Islands"),
    SOUTH_SUDAN("South Sudan"),
    SPAIN("Spain"),
    SPRATLY_ISLANDS("Spratly Islands"),
    SRI_LANKA("Sri Lanka"),
    SUDAN("Sudan"),
    SURINAME("Suriname"),
    SVALBARD("Svalbard"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    SYRIA("Syria"),
    TAIWAN("Taiwan"),
    TAJIKISTAN("Tajikistan"),
    TANZANIA("Tanzania"),
    THAILAND("Thailand"),
    TIMOR_LESTE("Timor-Leste"),
    TOGO("Togo"),
    TOKELAU("Tokelau"),
    TONGA("Tonga"),
    TRINIDAD_AND_TOBAGO("Trinidad and Tobago"),
    TRISTAN_DA_CUNHA("Tristan da Cunha"),
    TUNISIA("Tunisia"),
    TURKEY("Turkey"),
    TURKMENISTAN("Turkmenistan"),
    TURKS_AND_CAICOS_ISLANDS("Turks and Caicos Islands"),
    TUVALU("Tuvalu"),
    UGANDA("Uganda"),
    UKRAINE("Ukraine"),
    UNITED_ARAB_EMIRATES("United Arab Emirates"),
    UNITED_KINGDOM("United Kingdom"),
    UNITED_STATES("United States"),
    URUGUAY("Uruguay"),
    UZBEKISTAN("Uzbekistan"),
    VANUATU("Vanuatu"),
    VENEZUELA("Venezuela"),
    VIETNAM("Vietnam"),
    VIRGIN_ISLANDS_BRITISH("Virgin Islands, British"),
    VIRGIN_ISLANDS_U_S("Virgin Islands, U.S."),
    WAKE_ISLAND("Wake Island"),
    WALLIS_AND_FUTUNA("Wallis and Futuna"),
    WESTERN_SAHARA("Western Sahara"),
    YEMEN("Yemen"),
    ZAMBIA("Zambia"),
    ZIMBABWE("Zimbabwe"),
    BL("BL"),
    BQ("BQ"),
    CW("CW"),
    RS("RS"),
    SX("SX");

    private String value;

    Iso3166CountryCode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
