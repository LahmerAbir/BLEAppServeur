/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androidthings.gattserver;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import java.util.Calendar;
import java.util.UUID;

public class SensorProfile {
    private static final String TAG = SensorProfile.class.getSimpleName();

    /* Sensor Service UUID */
    public static UUID SENSOR_SERVICE = UUID.fromString("00001805-0000-1000-8000-00805f9b34fb");
    /* Sensor Information Characteristic */
    public static UUID SENSOR_CHARACTERISTIC    = UUID.fromString("00002a2b-0000-1000-8000-00805f9b34fb");
    /* Mandatory Client Characteristic Config Descriptor */
    public static UUID CLIENT_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");



    /**
     * Return a configured {@link BluetoothGattService} instance for the
     * Sensor Service.
     */
    public static BluetoothGattService createSensorService() {
        BluetoothGattService service = new BluetoothGattService(SENSOR_SERVICE,
                BluetoothGattService.SERVICE_TYPE_PRIMARY);

        // Current Time characteristic
        BluetoothGattCharacteristic Sensor_Chara = new BluetoothGattCharacteristic(SENSOR_CHARACTERISTIC,
                //Read-only characteristic, supports notifications
                BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor configDescriptor = new BluetoothGattDescriptor(CLIENT_CONFIG,
                //Read/write descriptor
                BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        Sensor_Chara.addDescriptor(configDescriptor);


        service.addCharacteristic(Sensor_Chara);

        return service;
    }


    }

