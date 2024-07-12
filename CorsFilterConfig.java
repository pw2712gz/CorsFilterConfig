@Bean
public CorsFilter corsFilter() {
    // Create a new CorsConfiguration object
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    
    // Allow credentials (cookies, authorization headers, etc.) to be included in requests
    corsConfiguration.setAllowCredentials(true);
    
    // Specify allowed origins (domains) for CORS requests
    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    
    // Specify allowed headers in CORS requests
    corsConfiguration.setAllowedHeaders(Arrays.asList(
        "Origin", "Access-Control-Allow-Origin", "Content-Type",
        "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
        "Access-Control-Request-Method", "Access-Control-Request-Headers"
    ));
    
    // Specify headers that can be exposed to the client in the response
    corsConfiguration.setExposedHeaders(Arrays.asList(
        "Origin", "Content-Type", "Accept", "Authorization",
        "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"
    ));
    
    // Specify allowed HTTP methods for CORS requests
    corsConfiguration.setAllowedMethods(Arrays.asList(
        "GET", "POST", "PUT", "DELETE", "OPTIONS"
    ));
    
    // Create a UrlBasedCorsConfigurationSource object and register the CORS configuration
    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    
    // Return a new CorsFilter with the configured CORS settings
    return new CorsFilter(urlBasedCorsConfigurationSource);
}
