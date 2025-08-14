function openModal(src) {
	  document.getElementById('modalImage').src = src;
	  const modal = new bootstrap.Modal(document.getElementById('imageModal'));
	  modal.show();
}