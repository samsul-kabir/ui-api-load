/*
 * File: app/view/ValidationForm.js
 */

Ext.define('TestApp.view.ValidationForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.validationForm',

    requires: [
        'Ext.form.field.Number',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Checkbox',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.form.Label',
        'Ext.toolbar.Fill',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Column',
        'TestApp.store.CustomerListStore'
    ],

    bodyPadding: 10,
    closable: true,
    title: 'Customer Info',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            defaults: {
                labelAlign: 'right',
                margin: '20 0 0 0'
            },
            items: [
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    fieldLabel: '<b>Form Titile * </b>',
                    name: 'title',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    fieldLabel: '<b>First Name *</b>',
                    name: 'firstname',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    fieldLabel: '<b>Last Name *</b>',
                    name: 'lastname'
                },
                {
                    xtype: 'numberfield',
                    anchor: '100%',
                    fieldLabel: '<b>Age * </b>',
                    name: 'age',
                    allowBlank: false,
                    maxValue: 100
                },
                {
                    xtype: 'combobox',
                    anchor: '100%',
                    fieldLabel: 'Manufacturer',
                    name: 'manufacturer',
                    allowBlank: false,
                    store: [
                        'Audi',
                        'BMW',
                        'Nissan',
                        'Porsche'
                    ]
                },
                {
                    xtype: 'checkboxfield',
                    anchor: '100%',
                    fieldLabel: 'hp > 150',
                    name: 'hp',
                    inputValue: 'true',
                    uncheckedValue: 'false'
                },
                {
                    xtype: 'textareafield',
                    anchor: '100%',
                    height: 116,
                    fieldLabel: 'Comments',
                    name: 'comments'
                },
                {
                    xtype: 'gridpanel',
                    height: 311,
                    title: 'Customer List',
                    forceFit: true,
                    store: 'CustomerListStore',
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'label',
                                    margin: '0 0 0 5',
                                    text: '  Select a Row and click load'
                                },
                                {
                                    xtype: 'tbfill'
                                },
                                {
                                    xtype: 'button',
                                    action: 'loadCustomerInfo',
                                    disabled: true,
                                    icon: 'resources/icons/load.png',
                                    text: '<b>Load</b>'
                                }
                            ]
                        }
                    ],
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'title',
                            text: 'Title'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'firstname',
                            text: 'Firstname'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'lastname',
                            text: 'Lastname'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'age',
                            text: 'Age'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'manufacturer',
                            text: 'Manufacturer'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'hp',
                            text: 'Hp > 150'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'comments',
                            text: 'Comments'
                        }
                    ],
                    listeners: {
                        selectionchange: {
                            fn: me.onGridpanelSelectionChange,
                            scope: me
                        }
                    }
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items: [
                        {
                            xtype: 'label',
                            margin: '0 0 0 10',
                            text: '"Required fields are marked with an asterisk (*) and must be filled to complete the form."'
                        }
                    ]
                },
                {
                    xtype: 'toolbar',
                    dock: 'top',
                    items: [
                        {
                            xtype: 'tbfill'
                        },
                        {
                            xtype: 'button',
                            action: 'resetCustomerInfo',
                            icon: 'resources/icons/cancel.png',
                            text: '<b>Reset</b>'
                        },
                        {
                            xtype: 'button',
                            action: 'saveCustomerInfo',
                            formBind: true,
                            icon: 'resources/icons/save.png',
                            text: '<b>Save</b>'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    onGridpanelSelectionChange: function(model, selected, eOpts) {
        this.down('button[action=loadCustomerInfo]').setDisabled(selected.length === 0);
    }

});