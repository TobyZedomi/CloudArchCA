#RESOURCEGROUP
$resource_Group = "ca1_rg"

#if resource group is already made

$check_resource_Group = az group exists --name $resource_Group

if ($check_resource_Group -eq "true"){

Write-Output "Resource Group $resource_Group already exist"

}else{

#Creation of resource group

az group create --name $resource_Group --location uksouth

#Virtual Network

az network vnet create -n ca1-vnet --resource-group $resource_Group --address-prefix 10.0.0.0/16 --subnet-name ca1-subnet-1 --subnet-prefixes 10.0.0.0/24


#Linux Virtual Machine

az vm create --resource-group $resource_Group --name ca1-VM --location uksouth --image Ubuntu2204 --size Standard_D2s_v3 --admin-username developer --admin-password Developer123@ --authentication-type password --vnet-name ca1-vnet --subnet ca1-subnet-1 --custom-data vm_init.yml

# Open 8080 port

az vm open-port -n ca1-VM -g $resource_Group --priority 200 --port 8080


}