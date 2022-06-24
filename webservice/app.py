#MEYFANDI ARDANIAWAN 19090106
#KINTAN FAIRUZIA 19090035


import os
import sys
import numpy as np
from util import base64_to_pil
from flask import Flask, request, render_template, jsonify
#from gevent.pywsgi import WSGIServer
import tensorflow as tf
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing import image

app = Flask(__name__)

model = load_model('models/model.h5') 
def model_predict(img, model):
    img = img.resize((224, 224))           
    x = image.img_to_array(img)
    x = x.reshape(-1, 224, 224, 3)
    x = x.astype('float32')
    x = x / 255.0
    preds = model.predict(x)
    return preds

@app.route('/', methods=['GET'])
def index():
    return render_template('index.html')

@app.route('/predict', methods=['GET', 'POST'])
def predict():
    if request.method == 'POST':
        img = base64_to_pil(request.json)
        preds = model_predict(img, model)

        target_names = ['Andre_Agassi', 'Alejandro_Toledo', 'Bill_Clinton', 'Atal_Bihari_Vajpayee', 'Alvaro_Uribe', 'Donald_Rumsfeld', 'David_Beckham', 'Colin_Powell', 'Ariel_Sharon', 'Arnold_Schwarzenegger']

        hasil_label = target_names[np.argmax(preds)]
        hasil_prob = "{:.2f}".format(100 * np.max(preds)) 
        return jsonify(result=hasil_label, probability=hasil_prob)

    return None

if __name__ == '__main__':
    # OPTION 1: NORMAL SERVE THE APP
    app.run(debug = True, port=5000, host='0.0.0.0')
    