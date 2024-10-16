package com.example.backend.controller.admin;

import com.example.backend.entity.SanPhamChiTiet;
import com.example.backend.repository.ImageRepository;
import com.example.backend.repository.SanPhamChiTietRepository;
import com.example.backend.repository.SanPhamRepository;
import com.example.backend.service.SanPhamChiTietService;
import com.example.backend.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sanPhamChiTiet")
public class SanPhamChiTietController {

    @Autowired
    SanPhamChiTietService sanPhamChiTietService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    ImageRepository hinhAnhRepository;

    @GetMapping("/danhSach")
    public ResponseEntity<List<SanPhamChiTiet>> getAll() {
        List<SanPhamChiTiet> list = sanPhamChiTietRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
