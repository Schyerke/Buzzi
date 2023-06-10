package com.example.tris_socket;

import java.net.Socket;

/**
 * @param role 1 == X 2 == O
 */
public record ClientSocketWrapper(int game, Socket socket, int role) {
}
