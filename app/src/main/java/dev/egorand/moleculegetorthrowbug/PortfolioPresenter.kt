package dev.egorand.moleculegetorthrowbug

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable fun PortfolioPresenter(): PortfolioModel {
  var portfolioModel by remember { mutableStateOf<PortfolioModel>(PortfolioModel.Loading) }
  LaunchedEffect("get-portfolio") {
    portfolioModel = PortfolioModel.Error("Boom!")
  }
  return portfolioModel
}
