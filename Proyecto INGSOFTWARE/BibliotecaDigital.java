import java.util.*;
/**
 * Clase principal BibliotecaDigital que representa la aplicación de biblioteca digital.
 * Proporciona funcionalidades para registrar usuarios, iniciar sesión, y gestionar recursos digitales.
 */
public class BibliotecaDigital {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Map<String, Subscription> subscriptions = new HashMap<>();
        subscriptions.put("Ciencias Naturales", new Subscription());
        subscriptions.put("Matemáticas", new Subscription());
        subscriptions.put("Programación", new Subscription());

        List<RecursoDigital> recursos = new ArrayList<>();
        List<RecursoDigital> recursosVIP = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Usuarios por defecto
        UsuarioFactory adminFactory = new AdministradorFactory();
        Usuario admin = adminFactory.crearUsuario(1, "Admin", "admin@example.com", "admin123", null);
        userManager.registerUser("admin", admin);

        UsuarioFactory normalUserFactory = new UsuarioNormalFactory();
        Usuario usuarioPrueba = normalUserFactory.crearUsuario(2, "Usuario1", "usuario1@example.com", "password1", "Programación");
        userManager.registerUser("usuario1", usuarioPrueba);

        while (true) {
            System.out.println("1. Iniciar sesión\n2. Registrar nuevo usuario\n3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            if (opcion == 1) {
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.nextLine();

                Usuario usuario = userManager.loginUser(username, password);
                if (usuario == null) {
                    System.out.println("Nombre de usuario o contraseña incorrectos.");
                    continue;
                }

                if (usuario instanceof Administrador) {
                    while (true) {
                        System.out.println("1. Agregar recurso\n2. Agregar contenido VIP\n3. Ver usuarios\n4. Ver suscripciones\n5. Ver recursos disponibles\n6. Cerrar sesión");
                        System.out.print("Seleccione una opción: ");
                        int adminOption = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea

                        if (adminOption == 1) {
                            System.out.print("Ingrese el nombre del recurso: ");
                            String nombreRecurso = scanner.nextLine();
                            System.out.print("Ingrese el tipo de recurso: ");
                            String tipoRecurso = scanner.nextLine();
                            System.out.print("Ingrese el contenido del recurso: ");
                            String contenidoRecurso = scanner.nextLine();
                            System.out.print("Ingrese la categoría del recurso (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                            int categoriaRecurso = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            String categoria = "";
                            if (categoriaRecurso == 1) {
                                categoria = "Ciencias Naturales";
                            } else if (categoriaRecurso == 2) {
                                categoria = "Matemáticas";
                            } else if (categoriaRecurso == 3) {
                                categoria = "Programación";
                            } else {
                                System.out.println("Categoría no válida. Recurso no agregado.");
                                continue;
                            }

                            RecursoDigital recurso = new RecursoDigital(recursos.size() + 1, nombreRecurso, tipoRecurso, contenidoRecurso, categoria);
                            recursos.add(recurso);
                            ((Administrador) usuario).agregarRecursoDigital(recurso, subscriptions);
                        } else if (adminOption == 2) {
                            System.out.print("Ingrese el nombre del recurso VIP: ");
                            String nombreRecurso = scanner.nextLine();
                            System.out.print("Ingrese el tipo de recurso: ");
                            String tipoRecurso = scanner.nextLine();
                            System.out.print("Ingrese el contenido del recurso: ");
                            String contenidoRecurso = scanner.nextLine();
                            System.out.print("Ingrese la categoría del recurso VIP (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                            int categoriaRecurso = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            String categoria = "";
                            if (categoriaRecurso == 1) {
                                categoria = "Ciencias Naturales";
                            } else if (categoriaRecurso == 2) {
                                categoria = "Matemáticas";
                            } else if (categoriaRecurso == 3) {
                                categoria = "Programación";
                            } else {
                                System.out.println("Categoría no válida. Recurso no agregado.");
                                continue;
                            }

                            RecursoDigital recursoVIP = new RecursoDigital(recursosVIP.size() + 1, nombreRecurso, tipoRecurso, contenidoRecurso, categoria);
                            recursosVIP.add(recursoVIP);
                            System.out.println("Recurso VIP agregado.");
                        } else if (adminOption == 3) {
                            ((Administrador) usuario).listarUsuarios(userManager.getUsers());
                        } else if (adminOption == 4) {
                            ((Administrador) usuario).verSuscripciones(subscriptions);
                        } else if (adminOption == 5) {
                            System.out.print("Ingrese la categoría a buscar (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                            int categoriaBusqueda = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            String categoria = "";
                            if (categoriaBusqueda == 1) {
                                categoria = "Ciencias Naturales";
                            } else if (categoriaBusqueda == 2) {
                                categoria = "Matemáticas";
                            } else if (categoriaBusqueda == 3) {
                                categoria = "Programación";
                            } else {
                                System.out.println("Categoría no válida.");
                                continue;
                            }

                            SearchEngine searchEngine = new SearchEngine(recursos);
                            List<RecursoDigital> resultados = searchEngine.searchByCategory(categoria);
                            for (RecursoDigital resultado : resultados) {
                                System.out.println("Recurso encontrado: " + resultado.getNombre());
                            }
                        } else if (adminOption == 6) {
                            usuario.logout();
                            break;
                        }
                    }
                } else {
                    while (true) {
                        System.out.println("1. Ver recursos disponibles\n2. Ver contenido VIP\n3. Hacer upgrade a VIP★\n4. Cerrar sesión");
                        System.out.print("Seleccione una opción: ");
                        int userOption = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea

                        if (userOption == 1) {
                            System.out.print("Ingrese la categoría a buscar (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                            int categoriaBusqueda = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            String categoria = "";
                            if (categoriaBusqueda == 1) {
                                categoria = "Ciencias Naturales";
                            } else if (categoriaBusqueda == 2) {
                                categoria = "Matemáticas";
                            } else if (categoriaBusqueda == 3) {
                                categoria = "Programación";
                            } else {
                                System.out.println("Categoría no válida.");
                                continue;
                            }

                            SearchEngine searchEngine = new SearchEngine(recursos);
                            List<RecursoDigital> resultados = searchEngine.searchByCategory(categoria);
                            for (RecursoDigital resultado : resultados) {
                                System.out.println("Recurso encontrado: " + resultado.getNombre());
                            }
                        } else if (userOption == 2) {
                            if (usuario instanceof UsuarioVIP) {
                                System.out.print("Ingrese la categoría a buscar (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                                int categoriaBusqueda = scanner.nextInt();
                                scanner.nextLine();  // Consumir la nueva línea

                                String categoria = "";
                                if (categoriaBusqueda == 1) {
                                    categoria = "Ciencias Naturales";
                                } else if (categoriaBusqueda == 2) {
                                    categoria = "Matemáticas";
                                } else if (categoriaBusqueda == 3) {
                                    categoria = "Programación";
                                } else {
                                    System.out.println("Categoría no válida.");
                                    continue;
                                }

                                SearchEngine searchEngine = new SearchEngine(recursosVIP);
                                List<RecursoDigital> resultados = searchEngine.searchByCategory(categoria);
                                for (RecursoDigital resultado : resultados) {
                                    System.out.println("Recurso VIP encontrado: " + resultado.getNombre());
                                }
                            } else {
                                System.out.println("Acceso denegado. No eres un usuario VIP.");
                            }
                        } else if (userOption == 3) {
                            System.out.print("Ingrese el código de upgrade a VIP: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            if (codigo == 1234) {
                                UsuarioVIP usuarioVIP = new UsuarioVIP(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getContraseña());
                                userManager.registerUser(usuario.getCorreo(), usuarioVIP);
                                System.out.println("¡Upgrade a VIP exitoso! Ahora puedes acceder a contenido exclusivo.");
                                usuario = usuarioVIP;  // Cambiar el objeto usuario a VIP
                            } else {
                                System.out.println("Código incorrecto.");
                            }
                        } else if (userOption == 4) {
                            usuario.logout();
                            break;
                        }
                    }
                }
            } else if (opcion == 2) {
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su correo: ");
                String correo = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();
                System.out.println("Seleccione su interés de suscripción:\n1. Ciencias Naturales\n2. Matemáticas\n3. Programación");
                int interesOpcion = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea
                final String interes;
                if (interesOpcion == 1) {
                    interes = "Ciencias Naturales";
                } else if (interesOpcion == 2) {
                    interes = "Matemáticas";
                } else if (interesOpcion == 3) {
                    interes = "Programación";
                } else {
                    System.out.println("Opción no válida. Usuario no registrado.");
                    continue;
                }

                Usuario usuarioNuevo = normalUserFactory.crearUsuario(userManager.getUsers().size() + 1, nombre, correo, contraseña, interes);
                userManager.registerUser(correo, usuarioNuevo);
                subscriptions.get(interes).subscribe(new Subscriber() {
                    @Override
                    public void update(String message) {
                        System.out.println("Nuevo recurso disponible para su interés: " + interes);
                    }
                });
                System.out.println("Usuario registrado exitosamente.");

                // Mostrar opciones para el nuevo usuario
                while (true) {
                    System.out.println("1. Ver recursos disponibles\n2. Ver contenido VIP\n3. Hacer upgrade a VIP★\n4. Cerrar sesión");
                    System.out.print("Seleccione una opción: ");
                    int userOption = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    if (userOption == 1) {
                        System.out.print("Ingrese la categoría a buscar (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                        int categoriaBusqueda = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea

                        String categoria = "";
                        if (categoriaBusqueda == 1) {
                            categoria = "Ciencias Naturales";
                        } else if (categoriaBusqueda == 2) {
                            categoria = "Matemáticas";
                        } else if (categoriaBusqueda == 3) {
                            categoria = "Programación";
                        } else {
                            System.out.println("Categoría no válida.");
                            continue;
                        }

                        SearchEngine searchEngine = new SearchEngine(recursos);
                        List<RecursoDigital> resultados = searchEngine.searchByCategory(categoria);
                        for (RecursoDigital resultado : resultados) {
                            System.out.println("Recurso encontrado: " + resultado.getNombre());
                        }
                    } else if (userOption == 2) {
                        if (usuarioNuevo instanceof UsuarioVIP) {
                            System.out.print("Ingrese la categoría a buscar (1. Ciencias Naturales, 2. Matemáticas, 3. Programación): ");
                            int categoriaBusqueda = scanner.nextInt();
                            scanner.nextLine();  // Consumir la nueva línea

                            String categoria = "";
                            if (categoriaBusqueda == 1) {
                                categoria = "Ciencias Naturales";
                            } else if (categoriaBusqueda == 2) {
                                categoria = "Matemáticas";
                            } else if (categoriaBusqueda == 3) {
                                categoria = "Programación";
                            } else {
                                System.out.println("Categoría no válida.");
                                continue;
                            }

                            SearchEngine searchEngine = new SearchEngine(recursosVIP);
                            List<RecursoDigital> resultados = searchEngine.searchByCategory(categoria);
                            for (RecursoDigital resultado : resultados) {
                                System.out.println("Recurso VIP encontrado: " + resultado.getNombre());
                            }
                        } else {
                            System.out.println("Acceso denegado. No eres un usuario VIP.");
                        }
                    } else if (userOption == 3) {
                        System.out.print("Ingrese el código de upgrade a VIP: ");
                        int codigo = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea

                        if (codigo == 1234) {
                            UsuarioVIP usuarioVIP = new UsuarioVIP(usuarioNuevo.getId(), usuarioNuevo.getNombre(), usuarioNuevo.getCorreo(), usuarioNuevo.getContraseña());
                            userManager.registerUser(usuarioNuevo.getCorreo(), usuarioVIP);
                            System.out.println("¡Upgrade a VIP exitoso! Ahora puedes acceder a contenido exclusivo.");
                            usuarioNuevo = usuarioVIP;  // Cambiar el objeto usuarioNuevo a VIP
                        } else {
                            System.out.println("Código incorrecto.");
                        }
                    } else if (userOption == 4) {
                        usuarioNuevo.logout();
                        break;
                    }
                }
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
                break;
            }
        }

        // Cerrar el Scanner
        scanner.close();
    }
}
