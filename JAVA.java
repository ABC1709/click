document.addEventListener("DOMContentLoaded", function () {
  const clickSwitch = document.getElementById("clickSwitch");
  let clicking = false;

  clickSwitch.addEventListener("change", function () {
    if (clickSwitch.checked) {
      clicking = true;
      startClicking();
    } else {
      clicking = false;
    }
  });

  function startClicking() {
    const clickInterval = 100; // Adjust the interval as needed (in milliseconds)
    
    function click() {
      if (clicking) {
        // Simulate a left mouse click
        const event = new MouseEvent("click", {
          bubbles: true,
          cancelable: true,
          view: window
        });
        const clickedElement = document.elementFromPoint(0, 0); // Click at the top-left corner of the page
        clickedElement.dispatchEvent(event);

        // Schedule the next click
        setTimeout(click, clickInterval);
      }
    }

    click(); // Start the clicking loop
  }
});
