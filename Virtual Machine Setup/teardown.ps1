#ResourceGroup

$resource_Group = "ca1_rg"

$check_resource_Group = az group exists --name $resource_Group

if ($check_resource_Group -eq "true"){

#delete resource group 

az group delete -n $resource_Group
Write-Output "Resource Group $resource_Group deleted"

}else{

Write-Output "Resource Group doesnt exist to delete"

}