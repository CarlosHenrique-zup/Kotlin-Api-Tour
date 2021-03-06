package com.acme.tour.controller

import com.acme.tour.model.ErrorMessage
import com.acme.tour.model.Promocao
import com.acme.tour.model.RespostaJSON
import com.acme.tour.service.PromocaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController(private val promocaoService: PromocaoService) {

    @GetMapping()
    fun getAll(
        @RequestParam(required = false, defaultValue = "0") start: Int,
        @RequestParam(required = false, defaultValue = "3") size: Int
    ): ResponseEntity<List<Promocao>> {
        val listPromocoes = this.promocaoService.getAll(start, size)
        val status = if (listPromocoes.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(listPromocoes, status)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        val promocao = this.promocaoService.getById(id)
        return if (promocao != null)
            ResponseEntity(promocao, HttpStatus.OK)
        else
            ResponseEntity(
                ErrorMessage("Processo não Localizado", "Promoção ${id} não localizada"),
                HttpStatus.NOT_FOUND
            )
    }

    @PostMapping()
    fun create(@RequestBody promocao: Promocao): ResponseEntity<RespostaJSON> {
        this.promocaoService.create(promocao)
        val respostaJSON = RespostaJSON("Promoção criada com Sucesso!", Date())
        return ResponseEntity(respostaJSON, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        //TODO trycatch
        try{
            status = HttpStatus.ACCEPTED
            this.promocaoService.delete(id)
        }catch(e: Exception){
            println(e.message)
        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getById(id) != null) {
            this.promocaoService.update(id, promocao)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String, Long>> =
        ResponseEntity.ok().body(mapOf("count" to this.promocaoService.count()))

    @GetMapping("/ordernados")
    fun ordenados() = this.promocaoService.getAllSortedByLocal()
}