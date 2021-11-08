package net.proyectoSoftwareII.Proyecto.security;



public class SecurityConstants {

    public static final Long EXPIRATION_DATE = (long) 864000000; // El token con el que se consumirá el servicio durará 10 días
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String TOKEN_STRING = "Authorization";
    public static final String SING_UP_URL = "/users";
    public static final String TOKEN_SECRET = "UaChoAVm5ngHor7zPOjYgPtciKPjjT8y";
}

 