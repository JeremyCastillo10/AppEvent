import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.State
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.AppEvent.data.remote.dto.Asientodto
import com.example.AppEvent.data.remote.dto.Eventodto
import com.example.AppEvent.ui.AsientoList.AsientoListViewModel
import com.example.AppEvent.ui.EventoList.EventoListViewModel
@Composable
fun EventoListScreen(
    onClick: () -> Unit,
    viewModel: EventoListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Lista de Eventos")
                },
                actions = {
                    IconButton(onClick = { viewModel.refresh() }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Refresh"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Add")
            }
        }
    ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier.fillMaxSize()) {
            EventoLista(evento = uiState.evento)
        }
    }
}

@Composable
fun EventoLista(
    evento: List<Eventodto>,
    modifier: Modifier = Modifier,
    viewModel: EventoListViewModel = hiltViewModel()
) {
    LazyColumn(modifier = modifier) {
        items(evento) { evento ->
            EventoRow(evento, viewModel)
        }
    }
}

@Composable
fun EventoRow(evento: Eventodto, viewModel: EventoListViewModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { /* Acción al hacer clic en el evento */ },
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = evento.imagenUrl,
                    builder = {
                        crossfade(true) // Opcional: habilitar efecto de fundido al cargar la imagen
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = evento.nombreEvento,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = evento.fecha,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface
                )
            }

            IconButton(
                onClick = { viewModel.Delete(evento.eventoId) },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = MaterialTheme.colors.error
                )
            }
        }
    }
}
