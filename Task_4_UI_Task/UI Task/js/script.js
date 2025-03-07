
document.addEventListener("DOMContentLoaded", function () {
  const customWorkoutModal = document.getElementById("customWorkoutModal");
  const exerciseModal = document.getElementById("exerciseModal");
  const exerciseList = document.getElementById("exerciseList");
  const selectedExercises = document.getElementById("selectedExercises");
  const workoutNameInput = document.getElementById("workoutName");
  const detailsButtons = document.querySelectorAll(".fp-workout-card .btn-outline-light");
  const addToRoutineButtons = document.querySelectorAll(".fp-workout-card .btn-primary");

  const workouts = {
    "Full-Body Workout": [
      { name: "Squats", reps: "10-12" },
      { name: "Push-ups", reps: "12-15" },
      { name: "Deadlifts", reps: "8-10" },
      { name: "Pull-ups", reps: "8-12" },
      { name: "Lunges", reps: "10 per leg" },
      { name: "Shoulder Press", reps: "10-12" },
      { name: "Bent-over Rows", reps: "8-10" },
      { name: "Plank", reps: "45-60 sec" },
      { name: "Bicep Curls", reps: "12" },
      { name: "Tricep Dips", reps: "10-12" },
    ],
    "Arm Workout": [
      { name: "Bicep Curls", reps: "12" },
      { name: "Hammer Curls", reps: "12" },
      { name: "Tricep Dips", reps: "10-12" },
      { name: "Overhead Tricep Extension", reps: "10" },
      { name: "Concentration Curls", reps: "12" },
      { name: "Close-grip Push-ups", reps: "15" },
    ],
    "Abs Workout": [
      { name: "Crunches", reps: "15" },
      { name: "Leg Raises", reps: "12" },
      { name: "Russian Twists", reps: "20 (10 per side)" },
      { name: "Bicycle Crunches", reps: "20 (10 per side)" },
      { name: "Hanging Leg Raises", reps: "12" },
      { name: "Plank", reps: "60 sec" },
    ],
    "Leg Workout": [
      { name: "Squats", reps: "12" },
      { name: "Lunges", reps: "10 per leg" },
      { name: "Deadlifts", reps: "8-10" },
      { name: "Step-ups", reps: "12 per leg" },
      { name: "Calf Raises", reps: "15" },
      { name: "Leg Press", reps: "12" },
    ],
  };
  detailsButtons.forEach((button) => {
    button.addEventListener("click", function () {
      const workoutCard = button.closest(".fp-workout-card");
      const workoutName = workoutCard.querySelector("h3").textContent.trim();

      if (!workouts[workoutName]) {
        alert("Workout details not found!");
        return;
      }

      const workoutDetails = workouts[workoutName]
        .map((exercise) => `<li>${exercise.name} – ${exercise.reps}</li>`)
        .join("");

      document.getElementById("modal-title").textContent = workoutName;
      document.getElementById("modal-body").innerHTML = `<ul>${workoutDetails}</ul>`;

      const detailsModal = new bootstrap.Modal(document.getElementById("workoutModal"));
      detailsModal.show();
    });
  });

  addToRoutineButtons.forEach((button) => {
    button.addEventListener("click", function () {
      const workoutCard = button.closest(".fp-workout-card");
      const workoutName = workoutCard.querySelector("h3").textContent.trim();

      if (!workouts[workoutName]) {
        alert("Workout details not found!");
        return;
      }

      let storedRoutines = JSON.parse(localStorage.getItem("fitnessRoutines")) || [];

      if (storedRoutines.some((routine) => routine.name === workoutName)) {
        alert("Workout already added!");
        return;
      }

      const newRoutine = {
        name: workoutName,
        exercises: workouts[workoutName].map((exercise) => ({
          name: exercise.name,
          reps: exercise.reps,
        })),
        completed: false,
        createdAt: new Date().toLocaleString(),
      };

      storedRoutines.push(newRoutine);
      localStorage.setItem("fitnessRoutines", JSON.stringify(storedRoutines));
      alert(`${workoutName} added to your routine!`);
    });
  });
  const exercises = [
    { name: "Squats", reps: 12, sec: 0 },
    { name: "Push-ups", reps: 15, sec: 0 },
    { name: "Deadlifts", reps: 10, sec: 0 },
    { name: "Pull-ups", reps: 10, sec: 0 },
    { name: "Lunges", reps: 10, sec: 0 },
    { name: "Shoulder Press", reps: 12, sec: 0 },
    { name: "Bent-over Rows", reps: 10, sec: 0 },
    { name: "Plank", reps: 0, sec: 60 },
    { name: "Bicep Curls", reps: 12, sec: 0 },
    { name: "Tricep Dips", reps: 12, sec: 0 },
    { name: "Hammer Curls", reps: 12, sec: 0 },
    { name: "Overhead Tricep Extension", reps: 10, sec: 0 },
    { name: "Concentration Curls", reps: 12, sec: 0 },
    { name: "Crunches", reps: 15, sec: 0 },
    { name: "Leg Raises", reps: 12, sec: 0 },
    { name: "Russian Twists", reps: 20, sec: 0 },
    { name: "Bicycle Crunches", reps: 20, sec: 0 },
    { name: "Hanging Leg Raises", reps: 12, sec: 0 },
    { name: "Step-ups", reps: 12, sec: 0 },
    { name: "Calf Raises", reps: 15, sec: 0 },
    { name: "Leg Press", reps: 12, sec: 0 },
    { name: "Wall Sit", reps: 0, sec: 45 },
    { name: "Plank Shoulder Taps", reps: 20, sec: 0 },
    { name: "Side Plank", reps: 0, sec: 30 },
  ];

  detailsButtons.forEach((button, index) => {
    button.addEventListener("click", function () {
      const workoutCard = button.closest(".fp-workout-card");
      const workoutName = workoutCard.querySelector("h3").textContent;
      const workoutImage = workoutCard.querySelector("img").src;

      document.getElementById("modal-title").textContent = workoutName;
      document.getElementById("modal-image").src = workoutImage;

      const detailsModal = new bootstrap.Modal(document.getElementById("workoutModal"));
      detailsModal.show();
    });
  });
  function openModal() {
    selectedExercises.innerHTML = "";
    workoutNameInput.value = "";

    customWorkoutModal.classList.add("show");
    customWorkoutModal.style.display = "flex";
    document.body.classList.add("modal-open");
  }

  function closeModal() {
    customWorkoutModal.classList.remove("show");
    customWorkoutModal.style.display = "none";
    document.body.classList.remove("modal-open");
  }

  function openExerciseModal() {
    exerciseModal.classList.add("show");
    exerciseModal.style.display = "flex";
    document.body.classList.add("modal-open");
    loadExerciseList();
  }

  function closeExerciseModal() {
    exerciseModal.classList.remove("show");
    exerciseModal.style.display = "none";
    document.body.classList.remove("modal-open");
  }

  function loadExerciseList() {
    exerciseList.innerHTML = "";
    exercises.forEach((exercise) => {
      const button = document.createElement("button");
      button.className = "list-group-item list-group-item-action";
      button.textContent = exercise.name;
      button.onclick = function () {
        addExercise(exercise.name, exercise.reps, exercise.sec);
      };
      exerciseList.appendChild(button);
    });
  }
function openCustomExerciseModal() {
  const modalElement = document.getElementById("customExerciseModal");
  const modal = new bootstrap.Modal(modalElement);

  modalElement.removeAttribute("aria-hidden"); 
  modalElement.removeAttribute("inert");
  modal.show();
}

function closeCustomExerciseModal() {
  const modalElement = document.getElementById("customExerciseModal");
  const modal = bootstrap.Modal.getInstance(modalElement);

  modal.hide();
  modalElement.setAttribute("aria-hidden", "true");
  modalElement.setAttribute("inert", "");
}


  function addCustomExercise() {
    const exerciseName = document
      .getElementById("customExerciseName")
      .value.trim();
    const reps =
      parseInt(document.getElementById("customReps").value.trim(), 10) || 0;
    const sec =
      parseInt(document.getElementById("customSec").value.trim(), 10) || 0;

    if (!exerciseName) {
      alert("Please enter an exercise name!");
      return;
    }
    if (reps === 0 && sec === 0) {
      alert("Please enter either reps or seconds!");
      return;
    }

    addExercise(exerciseName, reps, sec);
    closeCustomExerciseModal();
  }

  function addExercise(exerciseName, defaultReps, defaultSec) {
    if (
      [...selectedExercises.children].some(
        (div) => div.dataset.name === exerciseName
      )
    ) {
      alert("This exercise is already added!");
      return;
    }

    const exerciseDiv = document.createElement("div");
    exerciseDiv.className =
      "alert alert-info d-flex justify-content-between align-items-center w-100 p-2";
    exerciseDiv.dataset.name = exerciseName;

    const nameSpan = document.createElement("span");
    nameSpan.textContent = exerciseName;
    nameSpan.className = "fw-bold text-center";
    nameSpan.style.minWidth = "150px";
    exerciseDiv.appendChild(nameSpan);

    const inputContainer = document.createElement("div");
    inputContainer.className = "d-flex align-items-center gap-3";

    if (defaultReps > 0) {
      const repLabel = document.createElement("span");
      repLabel.textContent = "Reps:";
      repLabel.className = "fw-semibold";
      inputContainer.appendChild(repLabel);

      const repInput = document.createElement("input");
      repInput.type = "number";
      repInput.value = defaultReps;
      repInput.className = "form-control text-center";
      repInput.style.width = "60px";
      inputContainer.appendChild(repInput);
    }

    if (defaultSec > 0) {
      const secLabel = document.createElement("span");
      secLabel.textContent = "Sec:";
      secLabel.className = "fw-semibold";
      inputContainer.appendChild(secLabel);

      const secInput = document.createElement("input");
      secInput.type = "number";
      secInput.value = defaultSec;
      secInput.className = "form-control text-center";
      secInput.style.width = "60px";
      inputContainer.appendChild(secInput);
    }

    const removeButton = document.createElement("button");
    removeButton.className = "btn-close ms-3";
    removeButton.onclick = function () {
      exerciseDiv.remove();
    };

    exerciseDiv.appendChild(inputContainer);
    exerciseDiv.appendChild(removeButton);
    selectedExercises.appendChild(exerciseDiv);

    closeExerciseModal();
  }

  function saveRoutine() {
    const workoutName = workoutNameInput.value.trim();
    if (!workoutName) {
      alert("Please enter a workout name!");
      return;
    }
  
    let storedRoutines = JSON.parse(localStorage.getItem("fitnessRoutines")) || [];
    if (storedRoutines.some((routine) => routine.name === workoutName)) {
      alert("A routine with this name already exists!");
      return;
    }
  
    const createdAt = new Date().toLocaleString();
  
    const selectedExerciseData = [...selectedExercises.children].map((div) => ({
      name: div.dataset.name,
      reps: div.querySelector("input[type='number']")?.value || 0,
      sec: div.querySelectorAll("input[type='number']")[1]?.value || 0,
      completed: false,
    }));
  
    const newRoutine = {
      name: workoutName,
      exercises: selectedExerciseData,
      completed: false,
      createdAt: createdAt, 
    };
  
    storedRoutines.push(newRoutine);
    localStorage.setItem("fitnessRoutines", JSON.stringify(storedRoutines));
  
    window.location.href = "MyRoutine.html";
  }
  

  window.openModal = openModal;
  window.closeModal = closeModal;
  window.openExerciseModal = openExerciseModal;
  window.closeExerciseModal = closeExerciseModal;
  window.addExercise = addExercise;
  window.saveRoutine = saveRoutine;
  window.openCustomExerciseModal = openCustomExerciseModal;
  window.closeCustomExerciseModal = closeCustomExerciseModal;
  window.addCustomExercise = addCustomExercise;
});
