package com.servlets;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jpa.entities.Produtos;
import com.jpa.session.ProdutosFacade;

public class ImageServlet extends HttpServlet {

    private static final int DEFAULT_BUFFER_SIZE = 10240;
    @EJB
    private ProdutosFacade produtosFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String produtoId = request.getParameter("id");

        if (produtoId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        Produtos produto = produtosFacade.find(Integer.parseInt(produtoId));
        byte[] imagem = produto.getImagem();

        if (produto == null || imagem == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType("image/jpeg");
        response.setContentType("image/gif");
        response.setContentType("image/png");
        response.setContentType("image/bmp");
        response.setContentLength(imagem.length);
        response.setHeader("Expires", "Thu,  Apr 2014 20:00:00 GMT");

        BufferedOutputStream output = null;

        try {
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
            output.write(produto.getImagem());
        } finally {
            close(output);
        }
    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
