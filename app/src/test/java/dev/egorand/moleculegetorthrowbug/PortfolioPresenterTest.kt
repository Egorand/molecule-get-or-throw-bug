package dev.egorand.moleculegetorthrowbug

import app.cash.molecule.RecompositionClock.Immediate
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PortfolioPresenterTest {
  @Test fun `loads portfolio`() = runBlocking {
    makePresenter().test {
      assertThat(awaitItem()).isEqualTo(PortfolioModel.Loading)
      assertThat(awaitItem()).isEqualTo(PortfolioModel.Error("Boom!"))
    }
  }

  private fun makePresenter(): Flow<PortfolioModel> {
    return moleculeFlow(clock = Immediate) {
      PortfolioPresenter()
    }
  }
}
