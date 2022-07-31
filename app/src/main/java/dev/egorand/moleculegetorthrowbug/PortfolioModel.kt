package dev.egorand.moleculegetorthrowbug

sealed class PortfolioModel {
  object Loading : PortfolioModel()
  data class Error(val message: String) : PortfolioModel()
}
