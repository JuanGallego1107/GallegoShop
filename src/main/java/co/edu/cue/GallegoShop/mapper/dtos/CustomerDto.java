package co.edu.cue.GallegoShop.mapper.dtos;

public record CustomerDto(
        Integer customerId,
        String customerName,
        String customerEmail,
        String adress
) {
}
