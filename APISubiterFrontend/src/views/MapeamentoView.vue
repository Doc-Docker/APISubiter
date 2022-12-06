<template>
  
  <div>
        <div class="button-container">
        <input type="file" @change="setImage($event)"  class="form-control inputFile" />
        <div class="button-container">
        <select v-model="strokeType" class="form-select selectWidth espacoInicial ">
          <option value="dash">Caneta</option>
          <option value="line">Linha</option>
          <option value="circle">Circulo</option>
          <option value="square">Quadrado</option>
          <option value="triangle">Triangulo</option>
          <option value="half_triangle">Triangulo R</option>
        </select>
        <select v-model="line" class="form-select widthNum">
          <option v-for="n in 25" :key="'option-' + n" :value="n">
            {{ n }}
          </option>
        </select>
        <input type="color" v-model="color" class="widthColor" />
      </div>
        <button type="button" @click.prevent="eraser = !eraser" class="btn btn-warning espaco" >
          <span v-if="eraser">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="19"
              height="19"
              fill="currentColor"
              class="bi bi-eraser"
              viewBox="0 0 16 16"
            >
              <path
                d="M8.086 2.207a2 2 0 0 1 2.828 0l3.879 3.879a2 2 0 0 1 0 2.828l-5.5 5.5A2 2 0 0 1 7.879 15H5.12a2 2 0 0 1-1.414-.586l-2.5-2.5a2 2 0 0 1 0-2.828l6.879-6.879zm2.121.707a1 1 0 0 0-1.414 0L4.16 7.547l5.293 5.293 4.633-4.633a1 1 0 0 0 0-1.414l-3.879-3.879zM8.746 13.547 3.453 8.254 1.914 9.793a1 1 0 0 0 0 1.414l2.5 2.5a1 1 0 0 0 .707.293H7.88a1 1 0 0 0 .707-.293l.16-.16z"
              />
            </svg>
          </span>
          <span v-else>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="19"
              height="19"
              fill="currentColor"
              class="bi bi-pencil"
              viewBox="0 0 16 16"
            >
              <path
                d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"
              />
            </svg>
          </span>
        </button>        
        <button type="button" @click.prevent="disabled = !disabled" class="btn btn-primary espaco" >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-lock"
            viewBox="0 0 16 16"
          >
            <path
              v-if="!disabled"
              d="M11 1a2 2 0 0 0-2 2v4a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h5V3a3 3 0 0 1 6 0v4a.5.5 0 0 1-1 0V3a2 2 0 0 0-2-2zM3 8a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V9a1 1 0 0 0-1-1H3z"
            />
            <path
              v-else
              d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"
            />
          </svg>
          <span v-if="!disabled"></span>
          <span v-else></span>
        </button>
        <button type="button" @click.prevent="$refs.VueCanvasDrawing.undo()" class="btn btn-secondary espaco" title="Desfazer"  data-toggle="tooltip" data-placement="right">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-arrow-counterclockwise"
            viewBox="0 0 16 16"
          >
            <path
              fill-rule="evenodd"
              d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"
            />
            <path
              d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"
            />
          </svg>
        </button>
        <button type="button" @click.prevent="$refs.VueCanvasDrawing.redo()" class="btn btn-secondary espaco">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-arrow-clockwise"
            viewBox="0 0 16 16"
          >
            <path
              fill-rule="evenodd"
              d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"
            />
            <path
              d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"
            />
          </svg>
        </button>
        <button type="button" @click.prevent="$refs.VueCanvasDrawing.reset()" class="btn btn-secondary espaco">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-file-earmark"
            viewBox="0 0 16 16"
          >
            <path
              d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"
            />
          </svg>
        </button>
      </div>
      <div class="button-container">
        <button type="button" @click.prevent="getStrokes()" class="btn btn-success espaco" 
          data-toggle="tooltip" data-placement="right" title="Salvar">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-image-alt"
            viewBox="0 0 16 16"
          >
            <path
              d="M7 2.5a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0zm4.225 4.053a.5.5 0 0 0-.577.093l-3.71 4.71-2.66-2.772a.5.5 0 0 0-.63.062L.002 13v2a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1v-4.5l-4.777-3.947z"
            />
          </svg>
        </button>
        <button type="button" @click.prevent="removeSavedStrokes()" class="btn btn-danger espaco">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="19"
            height="19"
            fill="currentColor"
            class="bi bi-eraser"
            viewBox="0 0 16 16"
          >
            <path
              d="M8.086 2.207a2 2 0 0 1 2.828 0l3.879 3.879a2 2 0 0 1 0 2.828l-5.5 5.5A2 2 0 0 1 7.879 15H5.12a2 2 0 0 1-1.414-.586l-2.5-2.5a2 2 0 0 1 0-2.828l6.879-6.879zm2.121.707a1 1 0 0 0-1.414 0L4.16 7.547l5.293 5.293 4.633-4.633a1 1 0 0 0 0-1.414l-3.879-3.879zM8.746 13.547 3.453 8.254 1.914 9.793a1 1 0 0 0 0 1.414l2.5 2.5a1 1 0 0 0 .707.293H7.88a1 1 0 0 0 .707-.293l.16-.16z"
            />
          </svg>
        </button>
        <button type="button" @click.prevent="exportarImagem()" class="btn btn-info espaco">
          <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
            <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
            <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
          </svg>
        </button>


        <button class="btn btn-secondary btnVoltar" @click="sair()">Voltar</button>
      </div>
    <center>
      <div class="canvas">
            <vue-drawing-canvas
                ref="VueCanvasDrawing"
                :image.sync="image"
                :width="1350"
                :height="620"
                :stroke-type="strokeType"
                :line-cap="lineCap"
                :line-join="lineJoin"
                :fill-shape="fillShape"
                :eraser="eraser"
                :lineWidth="line"
                :color="color"
                :background-color="backgroundColor"
                :background-image="backgroundImage"
                :watermark="watermark"
                :initial-image="initialImage"
                saveAs="png"
                :styles="{
                border: 'solid 1px #000'
                }"
                :lock="disabled"
                @mousemove.native="getCoordinate($event)"
                :additional-images="additionalImages"
            />
      </div>
      </center>
  </div>

</template>

<script type="module">
import VueDrawingCanvas from "vue-drawing-canvas/dist/vue-drawing-canvas.esm";
import router from '../router';
import saveAs from 'save-as';

//import LogoParaImagem from '../assets/logo-para-img.png';

export default {
  components: {
    "vue-drawing-canvas": VueDrawingCanvas,
  },
  setup: () => {},
  data() {
    return {
      initialImage: [
        {
          type: "dash",
          from: {
            x: 262,
            y: 154,
          },
          coordinates: [],
          color: "#000000",
          width: 5,
          fill: false,
        },
      ],
      x: 0,
      y: 0,
      image: "",
      eraser: false,
      disabled: false,
      fillShape: false,
      line: 5,
      color: "#000000",
      strokeType: "dash",
      lineCap: "round",
      lineJoin: "round",
      backgroundColor: "#FFFFFF",
      backgroundImage: null,
      watermark: null,
      additionalImages: [],
    };
  },
  mounted() {
    if ("vue-drawing-canvas" in window.localStorage) {
      this.initialImage = JSON.parse(
        window.localStorage.getItem("vue-drawing-canvas")
      );
    }
  },
  methods: {
    async setImage(event) {
      let URL = window.URL;
      this.backgroundImage = URL.createObjectURL(event.target.files[0]);
      await this.$refs.VueCanvasDrawing.redraw();
    },
    getCoordinate(event) {
      let coordinates = this.$refs.VueCanvasDrawing.getCoordinates(event);
      this.x = coordinates.x;
      this.y = coordinates.y;
    },
    getStrokes() {
      window.localStorage.setItem(
        "vue-drawing-canvas",
        JSON.stringify(this.$refs.VueCanvasDrawing.getAllStrokes())
      );
      alert(
        "Mapeamento Salvo!"
      );
    },
    removeSavedStrokes() {
      window.localStorage.removeItem("vue-drawing-canvas");
      alert("Mapeamento Excluído!");
    },
    exportarImagem() {
      const canvas = document.getElementById("VueDrawingCanvas");
      canvas.toBlob(function(blob) {
        saveAs(blob, "Mapeamento.png");
      });
    },
    sair(){
      router.push("/");
    }
  },
};
</script>

<style scoped>
.flex-row {
  display: flex;
  flex-direction: row;
}
.button-container {
  width: 50px;
  margin-left: 30px;
}
.button-container > * {
  margin-top: 5px;
  margin-right: 10px;
}
.canvas {
  margin-left: 135px;
  margin-top: -638px;
}
.width {
  width: 60px;
  margin-top: 9px;
}
.espaco {
  margin-left: -26px;
}
.inputFile {
  margin-left: -26px;
  margin-bottom: 10px;
  margin-top: 23px;
  width: 400px;
}
.selectWidth {
  margin-top: 9px;
  width: 130px;
  margin-left: -26px;
}
.widthNum {
  width: 80px;
  margin-left: -55px;
}
.widthColor {
  width: 80px;
  margin-left: -55px;
  height: 35px;
  margin-top: 6px;
}
.espacamento {
  margin-top: 33px;
  margin-left: -55px;
}
.espacoInicial {
  margin-top: 20px;
  margin-left: -55px;
}
.btnVoltar {
  margin-top: 130px;
  margin-left: 6px;
}
.espacoAmarelo {
  margin-left: -40px;
}
</style>
