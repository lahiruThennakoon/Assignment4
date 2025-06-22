package utils;

import config.ConfigReader;

public class PayloadBuilder {

    public static String getSearchPayload(String term) {
        return "{\n" +
                "  \"context\": {\n" +
                "    \"apiKeys\": [\"" + ConfigReader.get("apiKey") + "\"]\n" +
                "  },\n" +
                "  \"recordQueries\": [\n" +
                "    {\n" +
                "      \"id\": \"productList\",\n" +
                "      \"typeOfRequest\": \"SEARCH\",\n" +
                "      \"settings\": {\n" +
                "        \"query\": {\n" +
                "          \"term\": \"" + term + "\"\n" +
                "        },\n" +
                "        \"typeOfRecords\": [\"KLEVU_PRODUCT\"],\n" +
                "        \"limit\": 36,\n" +
                "        \"sort\": \"PRICE_ASC\",\n" +
                "        \"fallbackQueryId\": \"productListFallback\"\n" +
                "      },\n" +
                "      \"filters\": {\n" +
                "        \"filtersToReturn\": {\n" +
                "          \"enabled\": true,\n" +
                "          \"options\": {\n" +
                "            \"order\": \"INDEX\",\n" +
                "            \"limit\": 70\n" +
                "          },\n" +
                "          \"rangeFilterSettings\": [\n" +
                "            {\n" +
                "              \"key\": \"klevu_price\",\n" +
                "              \"minMax\": \"true\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"productListFallback\",\n" +
                "      \"typeOfRequest\": \"SEARCH\",\n" +
                "      \"isFallbackQuery\": \"true\",\n" +
                "      \"settings\": {\n" +
                "        \"query\": {\n" +
                "          \"term\": \"*\"\n" +
                "        },\n" +
                "        \"typeOfRecords\": [\"KLEVU_PRODUCT\"],\n" +
                "        \"limit\": 36,\n" +
                "        \"searchPrefs\": [\"excludeDescription\"],\n" +
                "        \"sort\": \"RELEVANCE\"\n" +
                "      },\n" +
                "      \"filters\": {\n" +
                "        \"filtersToReturn\": {\n" +
                "          \"options\": {\n" +
                "            \"order\": \"INDEX\",\n" +
                "            \"limit\": 70\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"contentList\",\n" +
                "      \"typeOfRequest\": \"SEARCH\",\n" +
                "      \"settings\": {\n" +
                "        \"query\": {\n" +
                "          \"term\": \"ball\"\n" +
                "        },\n" +
                "        \"typeOfRecords\": [\"KLEVU_CMS\"],\n" +
                "        \"limit\": 36\n" +
                "      },\n" +
                "      \"filters\": {\n" +
                "        \"filtersToReturn\": {\n" +
                "          \"enabled\": true,\n" +
                "          \"options\": {\n" +
                "            \"order\": \"INDEX\",\n" +
                "            \"limit\": 70\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"noResultsFoundPopularProductList\",\n" +
                "      \"typeOfRequest\": \"SEARCH\",\n" +
                "      \"settings\": {\n" +
                "        \"query\": {\n" +
                "          \"term\": \"*\"\n" +
                "        },\n" +
                "        \"typeOfRecords\": [\"KLEVU_PRODUCT\"],\n" +
                "        \"limit\": 36,\n" +
                "        \"searchPrefs\": [\"ignoreManualBoosting\"]\n" +
                "      },\n" +
                "      \"filters\": {\n" +
                "        \"filtersToReturn\": {\n" +
                "          \"options\": {\n" +
                "            \"order\": \"INDEX\",\n" +
                "            \"limit\": 70\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
